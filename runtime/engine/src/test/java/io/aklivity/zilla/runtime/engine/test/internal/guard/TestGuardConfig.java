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
package io.aklivity.zilla.runtime.engine.test.internal.guard;

import java.time.Duration;

import io.aklivity.zilla.runtime.engine.config.GuardConfig;
import io.aklivity.zilla.runtime.engine.test.internal.guard.config.TestGuardOptionsConfig;

public final class TestGuardConfig
{
    public static final Duration DEFAULT_CHALLENGE_NEVER = Duration.ofMillis(0L);
    public static final Duration DEFAULT_LIFETIME_FOREVER = Duration.ofMillis(Long.MAX_VALUE);

    public final TestGuardOptionsConfig options;

    public TestGuardConfig(
        GuardConfig config)
    {
        this.options = (TestGuardOptionsConfig) config.options;
    }
}
