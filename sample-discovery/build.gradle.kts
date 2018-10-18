plugins {
    groovy
    eclipse
}

dependencies {
    compileOnly(Libraries.JSR305)
    implementation(Libraries.ASCIIDOCTORJ)
    implementation(Libraries.ASCIIDOCTORJ_API)
    implementation(Libraries.COMMONS_IO)
    implementation(Libraries.COMMONS_LANG3)
    implementation(Libraries.TYPESAFE_CONFIG)
    testImplementation(Libraries.SPOCK_CORE)
}


val path = project.getPath()
eclipse {
    project {
        name = (rootProject.name + path).replace(':', '-')
    }
}