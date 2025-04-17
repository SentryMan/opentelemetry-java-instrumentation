/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.helidon.internal;

import java.util.function.Function;

import javax.annotation.Nullable;

import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.opentelemetry.instrumentation.api.incubator.builder.internal.DefaultHttpServerInstrumenterBuilder;
import io.opentelemetry.instrumentation.helidon.JavaHttpServerTelemetryBuilder;

/**
 * This class is internal and is hence not for public use. Its APIs are unstable and can change at
 * any time.
 */
public class JavaHttpServerInstrumenterBuilderUtil {
  private JavaHttpServerInstrumenterBuilderUtil() {}

  @Nullable
  private static Function<
          JavaHttpServerTelemetryBuilder,
          DefaultHttpServerInstrumenterBuilder<ServerRequest, ServerResponse>>
      serverBuilderExtractor;

  @Nullable
  public static Function<
          JavaHttpServerTelemetryBuilder,
          DefaultHttpServerInstrumenterBuilder<ServerRequest, ServerResponse>>
      getServerBuilderExtractor() {
    return serverBuilderExtractor;
  }

  public static void setServerBuilderExtractor(
      Function<
              JavaHttpServerTelemetryBuilder,
              DefaultHttpServerInstrumenterBuilder<ServerRequest, ServerResponse>>
          serverBuilderExtractor) {
    JavaHttpServerInstrumenterBuilderUtil.serverBuilderExtractor = serverBuilderExtractor;
  }
}
