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
package io.aklivity.zilla.runtime.binding.amqp.internal.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.aklivity.zilla.runtime.binding.amqp.internal.types.AmqpCapabilities;

public final class AmqpConditionMatcher
{
    private final Matcher addressMatch;
    private final AmqpCapabilities capabilitiesMatch;

    public AmqpConditionMatcher(
        AmqpConditionConfig condition)
    {
        this.addressMatch = condition.address != null ? asMatcher(condition.address) : null;
        this.capabilitiesMatch = condition.capabilities;
    }

    public boolean matches(
        String topic,
        AmqpCapabilities capabilities)
    {
        return matchesAddress(topic) &&
                matchesCapabilities(capabilities);
    }

    private boolean matchesAddress(
        String topic)
    {
        return this.addressMatch == null || this.addressMatch.reset(topic).matches();
    }

    private boolean matchesCapabilities(
        AmqpCapabilities capabilities)
    {
        return this.capabilitiesMatch == null || (this.capabilitiesMatch.value() & capabilities.value()) != 0;
    }

    private static Matcher asMatcher(
        String wildcard)
    {
        return Pattern.compile(wildcard
                .replace(".", "\\.")
                .replace("$", "\\$")
                .replace("+", "[^/]*")
                .replace("#", ".*")).matcher("");
    }
}
