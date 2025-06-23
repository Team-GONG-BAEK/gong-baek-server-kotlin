plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
    mainClass.set("gongbaek.api.GongbaekApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin 전용
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // data
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // email
    implementation("org.springframework.boot:spring-boot-starter-mail")

    // valid
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // aop
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")

    // h2
    implementation("com.h2database:h2")

    // caffeine
    implementation("com.github.ben-manes.caffeine:caffeine")

    // aws
    implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // 멀티모듈 의존성
    implementation(project(":domain"))
    implementation(project(":infra"))
}

tasks.test {
    useJUnitPlatform()
}
