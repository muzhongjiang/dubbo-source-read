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

package org.apache.dubbo.common.serialize.nativejava;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.apache.dubbo.common.serialize.Constants.NATIVE_JAVA_SERIALIZATION_ID;

/**
 * 原生java序列化实现
 *
 * <pre>
 *     e.g. &lt;dubbo:protocol serialization="nativejava" /&gt;
 * </pre>
 */
public class NativeJavaSerialization implements Serialization {
    private static final Logger logger = LoggerFactory.getLogger(NativeJavaSerialization.class);
    private final static AtomicBoolean warn = new AtomicBoolean(false);

    @Override
    public byte getContentTypeId() {
        return NATIVE_JAVA_SERIALIZATION_ID;
    }

    @Override
    public String getContentType() {
        return "x-application/nativejava";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        if (warn.compareAndSet(false, true)) {
            //TODO ???
            logger.error("Java 序列化是不安全的。 Dubbo Team 不建议任何人使用。如果还想使用，请关注【JEP 290】(https://openjdk.java.net/jeps/290) 设置序列化过滤器以防止反序列化泄漏。");

        }
        return new NativeJavaObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        if (warn.compareAndSet(false, true)) {
            //TODO ???
            logger.error("Java 序列化是不安全的。 Dubbo Team 不建议任何人使用。 如果您还想使用它，请按照 [JEP 290](https://openjdk.java.net/jeps/290) 设置序列化过滤器以防止反序列化泄漏。");
        }
        return new NativeJavaObjectInput(input);
    }
}
