plugins {
    `fb-microservice`
}

group = "com.limeus.servicediscovery"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(libs.spring.cloud.starter.netflix.eureka.server)
    implementation(libs.database.postgresql)
    implementation(libs.database.h2)
}

dependencyManagement {
    dependencies {
        dependency("com.thoughtworks.xstream:xstream:1.4.21")
    }
}