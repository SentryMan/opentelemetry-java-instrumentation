/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.helidon;

import java.net.InetSocketAddress;
import java.util.List;

import javax.annotation.Nullable;

import io.helidon.http.HeaderNames;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.opentelemetry.instrumentation.api.semconv.http.HttpServerAttributesGetter;

enum HelidonAttributesGetter
    implements HttpServerAttributesGetter<ServerRequest, ServerResponse> {
  INSTANCE;

  @Override
  public String getHttpRequestMethod(ServerRequest exchange) {
    return exchange.prologue().method().text();
  }

  @Override
  public String getUrlScheme(ServerRequest exchange) {
    return exchange.requestedUri().scheme();
  }

  @Override
  public String getUrlPath(ServerRequest exchange) {
    return exchange.path().rawPath();
  }

  @Nullable
  @Override
  public String getUrlQuery(ServerRequest exchange) {
    return exchange.query().rawValue();
  }

  @Override
  public List<String> getHttpRequestHeader(ServerRequest req, String name) {
    return req.headers().values(HeaderNames.create(name));
  }

  @Nullable
  @Override
  public Integer getHttpResponseStatusCode(
      ServerRequest req, @Nullable ServerResponse res, @Nullable Throwable error) {

    return res.status().code();
  }

  @Override
  public List<String> getHttpResponseHeader(
      ServerRequest req, @Nullable ServerResponse res, String name) {
    return res.headers().values(HeaderNames.create(name));
  }

  @Override
  public String getHttpRoute(ServerRequest req) {
    return req.authority();
  }

  @Override
  public String getNetworkProtocolName(ServerRequest req, @Nullable ServerResponse res) {
    return req.prologue().protocol();
  }

  @Override
  public String getNetworkProtocolVersion(ServerRequest req, @Nullable ServerResponse res) {
    return req.prologue().protocolVersion();
  }

  @Override
  public InetSocketAddress getNetworkPeerInetSocketAddress(
      ServerRequest req, @Nullable ServerResponse res) {
    return (InetSocketAddress) req.remotePeer().address();
  }

  @Override
  public InetSocketAddress getNetworkLocalInetSocketAddress(
      ServerRequest req, @Nullable ServerResponse res) {
    return (InetSocketAddress) req.localPeer().address();
  }
}
