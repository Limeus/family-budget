package project.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask
import project.extensions.annotationProcessor
import project.extensions.implementation
import project.extensions.libs

const val OPENAPI_GENERATE_TASK_NAME = "openApiGenerate"
private const val ADD_GLOBAL_OPENAPI_GENERATION_IGNORE_TASK_NAME = "addGlobalOpenapiGenerationIgnore"

class FBOpenapiGenerationPlugin : Plugin<Project> {
    override fun apply(target: Project) = with (target) {
        with(pluginManager) {
            this.apply(libs.plugins.openapi.generator.get().pluginId)
        }

        dependencies {
            implementation(libs.spring.boot.starter.web)
            implementation(libs.spring.boot.starter.validation)
            implementation(libs.springdoc.openapi.starter.webmvc.ui)
            implementation(libs.lombok)
            annotationProcessor(libs.lombok)
        }

        configureTasks()
    }

    private fun Project.configureTasks() {
        tasks.named<GenerateTask>(OPENAPI_GENERATE_TASK_NAME) {
            dependsOn(ADD_GLOBAL_OPENAPI_GENERATION_IGNORE_TASK_NAME)
            generatorName.set("spring")
//            inputSpec.set("$projectDir/openapi.yaml")
//            outputDir.set("$projectDir/")
            inputSpec.set(file("$projectDir/openapi.yaml").toURI().toString())
            outputDir.set(file("$projectDir/").toString()) // это можно оставить как есть, URI здесь не нужен
            apiPackage.set("${project.group}.api")
            modelPackage.set("${project.group}.dto")
            invokerPackage.set("${project.group}.invoker")
            generateApiTests.set(false)
            generateModelTests.set(false)
            configOptions.set(mapOf(
                    "dateLibrary" to "java8",
                    "hideGenerationTimestamp" to "true",
                    "interfaceOnly" to "true",
                    "useSpringBoot3" to "true",
                    "useTags" to "true",
                    "openApiNullable" to "false",
                    "skipDefaultInterface" to "true",
            ))
        }

        tasks.register(ADD_GLOBAL_OPENAPI_GENERATION_IGNORE_TASK_NAME) {
            doLast {
                if (tasks.named<GenerateTask>(OPENAPI_GENERATE_TASK_NAME).get().ignoreFileOverride.isPresent) {
                    return@doLast
                }
                val globalIgnore = file("$rootDir/.openapi-generator-ignore")
                val projectIgnore = file("$projectDir/.openapi-generator-ignore")
                val targetDir = file("$projectDir/")

                // Создай глобальный .openapi-generator-ignore, если его нет
                if (!globalIgnore.exists()) {
                    globalIgnore.writeText("# Global OpenAPI ignore file\n")
                }

                if (projectIgnore.exists()) {
                    val lines = globalIgnore.readLines().toSet() - projectIgnore.readLines().toSet()
                    if (lines.isNotEmpty()) {
                        projectIgnore.appendText("\n${lines.joinToString("\n")}")
                    }
                } else {
                    copy {
                        from(globalIgnore)
                        into(targetDir)
                    }
                }
            }
        }
    }
}