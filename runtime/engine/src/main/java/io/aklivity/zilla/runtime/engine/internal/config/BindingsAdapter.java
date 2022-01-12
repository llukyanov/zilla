/*
 * Copyright 2021-2022 Aklivity Inc.
 *
 * Aklivity licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.aklivity.zilla.runtime.engine.internal.config;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;
import jakarta.json.bind.adapter.JsonbAdapter;

import org.agrona.collections.MutableInteger;

import io.aklivity.zilla.runtime.engine.config.Binding;
import io.aklivity.zilla.runtime.engine.config.NamespacedRef;
import io.aklivity.zilla.runtime.engine.config.Options;
import io.aklivity.zilla.runtime.engine.config.OptionsAdapterSpi;
import io.aklivity.zilla.runtime.engine.config.Role;
import io.aklivity.zilla.runtime.engine.config.Route;

public class BindingsAdapter implements JsonbAdapter<Binding[], JsonObject>
{
    private static final String VAULT_NAME = "vault";
    private static final String EXIT_NAME = "exit";
    private static final String TYPE_NAME = "type";
    private static final String KIND_NAME = "kind";
    private static final String OPTIONS_NAME = "options";
    private static final String ROUTES_NAME = "routes";

    private static final List<Route> ROUTES_DEFAULT = emptyList();

    private final RoleAdapter role;
    private final RouteAdapter route;
    private final OptionsAdapter options;

    public BindingsAdapter()
    {
        this.role = new RoleAdapter();
        this.route = new RouteAdapter();
        this.options = new OptionsAdapter(OptionsAdapterSpi.Kind.BINDING);
    }

    @Override
    public JsonObject adaptToJson(
        Binding[] bindings)
    {
        JsonObjectBuilder object = Json.createObjectBuilder();

        for (Binding binding : bindings)
        {
            route.adaptType(binding.type);
            options.adaptType(binding.type);

            JsonObjectBuilder item = Json.createObjectBuilder();

            if (binding.vault != null)
            {
                // TODO: qualified name format
                item.add(VAULT_NAME, binding.vault.name);
            }

            item.add(TYPE_NAME, binding.type);

            item.add(KIND_NAME, role.adaptToJson(binding.kind));

            if (binding.options != null)
            {
                item.add(OPTIONS_NAME, options.adaptToJson(binding.options));
            }

            if (!ROUTES_DEFAULT.equals(binding.routes))
            {
                JsonArrayBuilder routes = Json.createArrayBuilder();
                binding.routes.forEach(r -> routes.add(route.adaptToJson(r)));
                item.add(ROUTES_NAME, routes);
            }

            if (binding.exit != null)
            {
                item.add(EXIT_NAME, binding.exit.exit);
            }

            object.add(binding.entry, item);
        }

        return object.build();
    }

    @Override
    public Binding[] adaptFromJson(
        JsonObject object)
    {
        List<Binding> bindings = new LinkedList<>();

        for (String entry : object.keySet())
        {
            JsonObject item = object.getJsonObject(entry);
            String type = item.getString(TYPE_NAME);

            route.adaptType(type);
            options.adaptType(type);

            NamespacedRef vault = item.containsKey(VAULT_NAME)
                    ? NamespacedRef.of(item.getString(VAULT_NAME))
                    : null;
            Role kind = role.adaptFromJson(item.getJsonString(KIND_NAME));
            Options opts = item.containsKey(OPTIONS_NAME) ?
                    options.adaptFromJson(item.getJsonObject(OPTIONS_NAME)) :
                    null;
            MutableInteger order = new MutableInteger();
            List<Route> routes = item.containsKey(ROUTES_NAME)
                    ? item.getJsonArray(ROUTES_NAME)
                        .stream()
                        .map(JsonValue::asJsonObject)
                        .peek(o -> route.adaptFromJsonIndex(order.value++))
                        .map(route::adaptFromJson)
                        .collect(toList())
                    : ROUTES_DEFAULT;

            Route exit = item.containsKey(EXIT_NAME)
                    ? new Route(routes.size(), item.getString(EXIT_NAME))
                    : null;

            bindings.add(new Binding(vault, entry, type, kind, opts, routes, exit));
        }

        return bindings.toArray(Binding[]::new);
    }
}
