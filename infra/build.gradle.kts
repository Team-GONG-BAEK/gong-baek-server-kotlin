plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

repositories {
    mavenCentral()
}

dependencies {
    //aws
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")

    // Spring context (Bean 등록용)
    implementation("org.springframework.boot:spring-boot-starter")

    // Kotlin 필수 모듈
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // 테스트
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // 멀티모듈 의존성
    implementation(project(":domain"))
}
