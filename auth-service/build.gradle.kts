plugins {
    `fb-microservice`
    `fb-openapi-generation`
    java
}

group = "com.limeus.authservice"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

//repositories {
//    mavenCentral()
//}
dependencies {
    implementation(libs.database.postgresql)
    implementation(libs.database.h2)
}

//dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//}

tasks.withType<Test> {
    useJUnitPlatform()
}

//tasks.register("prepareKotlinBuildScriptModel") {}