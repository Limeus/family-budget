plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.openapi.generator.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("FBMicroservicePlugin") {
            id = libs.plugins.fb.microservice.get().pluginId
            implementationClass = "project.plugin.FBMicroservicePlugin"
        }
        register("FBOpenapiGenerationPlugin") {
            id = libs.plugins.fb.openapi.generation.get().pluginId
            implementationClass = "project.plugin.FBOpenapiGenerationPlugin"
        }
    }
}