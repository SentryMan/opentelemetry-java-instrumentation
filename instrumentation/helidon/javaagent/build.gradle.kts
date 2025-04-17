plugins {
  id("otel.javaagent-instrumentation")
}

muzzle {
  pass {
    coreJdk()
  }
}

dependencies {
  implementation(project(":instrumentation:helidon:library"))
  testImplementation(project(":instrumentation:helidon:testing"))
}
