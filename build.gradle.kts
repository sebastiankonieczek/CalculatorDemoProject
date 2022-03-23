plugins {
   java
}

repositories {
   mavenCentral()
}

dependencies {
   testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
   testImplementation("org.mockito:mockito-core:4.4.0")
   testImplementation("org.assertj:assertj-core:3.22.0")
}

tasks.named<Test>("test") {
   // Use JUnit Platform for unit tests.
   useJUnitPlatform()
}
