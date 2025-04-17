/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.helidon;

import io.helidon.webserver.http.HttpFeature;
import io.helidon.webserver.http.HttpRouting.Builder;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.api.instrumenter.Instrumenter;

/** Entrypoint for instrumenting Java HTTP Server services. */
public final class JavaHttpServerTelemetry implements HttpFeature {

  /**
   * Returns a new {@link JavaHttpServerTelemetry} configured with the given {@link OpenTelemetry}.
   */
  public static JavaHttpServerTelemetry create(OpenTelemetry openTelemetry) {
    return builder(openTelemetry).build();
  }

  public static JavaHttpServerTelemetryBuilder builder(OpenTelemetry openTelemetry) {
    return new JavaHttpServerTelemetryBuilder(openTelemetry);
  }

  private final Instrumenter<ServerRequest, ServerResponse> instrumenter;

  JavaHttpServerTelemetry(Instrumenter<ServerRequest, ServerResponse> instrumenter) {
    this.instrumenter = instrumenter;
  }

  @Override
  public void setup(Builder routing) {
    routing.addFilter(new OpenTelemetryFilter(instrumenter));
  }
}
