/*
 * Copyright 2021-2023 Aklivity Inc.
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
package io.aklivity.zilla.runtime.binding.mqtt.internal.config;

import static java.util.stream.Collectors.toList;

import java.util.List;

import io.aklivity.zilla.runtime.binding.mqtt.internal.types.MqttCapabilities;
import io.aklivity.zilla.runtime.engine.config.BindingConfig;
import io.aklivity.zilla.runtime.engine.config.KindConfig;

public final class MqttBindingConfig
{
    public final long id;
    public final String name;
    public final KindConfig kind;
    public final List<MqttRouteConfig> routes;

    public MqttBindingConfig(
        BindingConfig binding)
    {
        this.id = binding.id;
        this.name = binding.name;
        this.kind = binding.kind;
        this.routes = binding.routes.stream().map(MqttRouteConfig::new).collect(toList());
    }

    public MqttRouteConfig resolve(
        long authorization,
        MqttCapabilities capabilities)
    {
        return routes.stream()
            .filter(r -> r.authorized(authorization) && r.matches(capabilities))
            .findFirst()
            .orElse(null);
    }

    public MqttRouteConfig resolve(
        long authorization,
        String topic,
        MqttCapabilities capabilities)
    {
        return routes.stream()
            .filter(r -> r.authorized(authorization) && r.matches(topic, capabilities))
            .findFirst()
            .orElse(null);
    }
}
