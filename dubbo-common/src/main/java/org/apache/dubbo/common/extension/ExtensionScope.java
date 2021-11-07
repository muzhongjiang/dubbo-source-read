/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.extension;

import org.apache.dubbo.rpc.model.ApplicationModel;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ModuleModel;

/**
 * Extension SPI Scope
 *
 * @see SPI
 * @see ExtensionDirector
 */
public enum ExtensionScope {

    /**
     * 扩展实例在框架内使用，与所有应用程序和模块共享。
     * Framework scope SPI 扩展只能获取FrameworkModel，不能获取ApplicationModel 和ModuleModel。
     * 考虑：
     * <li>一些 SPI 需要在框架内的应用程序之间共享数据</li>
     * <li>无状态 SPI 在框架内安全共享</li>
     */
    FRAMEWORK,

    /**
     * 扩展实例在一个应用内使用，与应用的所有模块共享，不同的应用创建不同的扩展实例。
     * 应用范围SPI扩展可以获取FrameworkModel和ApplicationModel，不能获取ModuleModel。
     *
     * 考虑：
     * <li>在框架内的不同应用程序中隔离扩展数据</li>
     * <li>在应用程序内的所有模块之间共享扩展数据</li>
     *
     */
    APPLICATION,

    /**
     * The extension instance is used within one module, and different modules create different extension instances.
     *
     * <p>Module scope SPI extension can obtain {@link FrameworkModel}, {@link ApplicationModel} and {@link ModuleModel}.</p>
     *
     * <p></p>
     * Consideration:
     * <ol>
     * <li>Isolate extension data in different modules inside application</li>
     * </ol>
     */
    MODULE,

    /**
     * self-sufficient, creates an instance for per scope, for special SPI extension, like {@link ExtensionInjector}
     */
    SELF
}
