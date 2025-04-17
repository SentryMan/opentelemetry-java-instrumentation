plugins {
  id("otel.library-instrumentation")
  id("otel.nullaway-conventions")
}

dependencies {
  implementation enforcedPlatform("io.helidon:helidon-dependencies:4.2.0")
  implementation 'io.helidon.webserver:helidon-webserver'
  testImplementation(project(":instrumentation:helidon:testing"))
}
