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
package io.aklivity.zilla.runtime.binding.http.internal.config;

import java.util.Map;
import java.util.SortedSet;

import io.aklivity.zilla.runtime.binding.http.internal.types.String16FW;
import io.aklivity.zilla.runtime.binding.http.internal.types.String8FW;
import io.aklivity.zilla.runtime.engine.config.OptionsConfig;

public final class HttpOptionsConfig extends OptionsConfig
{
    public final SortedSet<HttpVersion>  versions;
    public final Map<String8FW, String16FW>  overrides;
    public final HttpAccessControlConfig access;
    public final HttpAuthorizationConfig authorization;

    public HttpOptionsConfig(
        SortedSet<HttpVersion>  versions,
        Map<String8FW, String16FW> overrides,
        HttpAccessControlConfig access,
        HttpAuthorizationConfig authorization)
    {
        this.versions = versions;
        this.overrides = overrides;
        this.access = access;
        this.authorization = authorization;
    }
}
