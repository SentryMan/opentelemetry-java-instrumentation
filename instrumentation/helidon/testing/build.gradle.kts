plugins {
  id("otel.java-conventions")
}

dependencies {
  api(project(":testing-common"))
  implementation enforcedPlatform("io.helidon:helidon-dependencies:4.2.0")
  implementation 'io.helidon.webserver:helidon-webserver'
}
