plugins {
    `fb-microservice`
    `fb-openapi-generation`
    id("java")
}

group = "com.limeus.commonlib"
version = "1.0-SNAPSHOT"

//repositories {
//    mavenCentral()
//}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(libs.bundles.jwt)
    implementation(libs.bundles.resourceSecurity)
}

tasks.test {
    useJUnitPlatform()
}

//tasks.register("prepareKotlinBuildScriptModel") {}