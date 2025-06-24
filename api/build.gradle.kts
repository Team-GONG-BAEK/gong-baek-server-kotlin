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
    // Cache
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("com.github.ben-manes.caffeine:caffeine")

    // web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // email, validation, aop
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-aop")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")


    // test
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // 멀티모듈 의존성
    implementation(project(":domain"))
    runtimeOnly(project(":infra"))
}

tasks.test {
    useJUnitPlatform()
}
