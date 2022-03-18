/*
 * Copyright 2021-2022 Aklivity Inc
 *
 * Licensed under the Aklivity Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 *   https://www.aklivity.io/aklivity-community-license/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package io.aklivity.zilla.runtime.binding.http.filesystem.internal;

import io.aklivity.zilla.runtime.engine.Configuration;

public class HttpFileSystemConfiguration extends Configuration
{
    private static final ConfigurationDef HTTP_FILE_SYSTEM_CONFIG;

    static
    {
        final ConfigurationDef config = new ConfigurationDef("zilla.binding.http.filesystem");
        HTTP_FILE_SYSTEM_CONFIG = config;
    }

    public HttpFileSystemConfiguration(
        Configuration config)
    {
        super(HTTP_FILE_SYSTEM_CONFIG, config);
    }
}
