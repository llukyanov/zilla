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
package io.aklivity.zilla.runtime.engine.internal.config;

import java.util.AbstractMap;
import java.util.Map;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.JsonValue;
import jakarta.json.bind.adapter.JsonbAdapter;

import io.aklivity.zilla.runtime.engine.config.AttributeConfig;

public class AttributeAdapter implements JsonbAdapter<AttributeConfig, Map.Entry<String, JsonValue>>
{
    @Override
    public Map.Entry<String, JsonValue> adaptToJson(
        AttributeConfig attributeConfig)
    {
        return new AbstractMap.SimpleEntry<>(attributeConfig.name, Json.createValue(attributeConfig.value));
    }

    @Override
    public AttributeConfig adaptFromJson(
        Map.Entry<String, JsonValue> entry)
    {
        return new AttributeConfig(entry.getKey(), asJsonString(entry.getValue()));
    }

    private static String asJsonString(
        JsonValue value)
    {
        return ((JsonString) value).getString();
    }
}
