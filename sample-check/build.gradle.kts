plugins {
    groovy
    eclipse
}

dependencies {
    constraints {
        testImplementation("org.codehaus.groovy:groovy-all:2.4.15")
    }
    api(project(":sample-discovery"))
    api(Libraries.JUNIT)
    compileOnly(Libraries.JSR305)
    implementation(Libraries.COMMONS_IO)
    implementation(Libraries.COMMONS_LANG3)
    implementation(gradleTestKit())
    testImplementation(Libraries.SPOCK_CORE)
    testImplementation(Libraries.CGLIB)
    testImplementation(Libraries.OBJENESIS)
}

// Add samples as inputs for testing
sourceSets["test"].resources.srcDirs("src/test/samples")


val path = project.getPath()
eclipse {
    project {
        name = (rootProject.name + path).replace(':', '-')
    }
}