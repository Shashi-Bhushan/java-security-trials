plugins {
  java
  kotlin("jvm") version "1.3.61"
}

group = "in.shabhushan"
version = "0.0.1-SNAPSHOT"


repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  compile("org.openjdk.jmh", "jmh-core", "1.23")
  compile("org.openjdk.jmh", "jmh-generator-annprocess", "1.23")

  api("org.eclipse.jetty", "jetty-util", "9.4.28.v20200408")

  testImplementation("org.junit.jupiter", "junit-jupiter", "5.6.2")
  // Use the Kotlin test library.
  testImplementation("org.jetbrains.kotlin:kotlin-test")

  // Use the Kotlin JUnit integration.
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
  implementation(kotlin("reflect"))
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_11
}
tasks {
  compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
  compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
  }
}
