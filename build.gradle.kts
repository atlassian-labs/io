plugins {
    kotlin("jvm").version(Versions.kotlin)
    maven
}

maven{
    group = "com.atlassian.test.performance"
    version = "0.0.1-SNAPSHOT"
}

dependencies {
    compile(Libs.kotlinStandard)
}