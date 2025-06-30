package gongbaek.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["gongbaek"]
)
class GongbaekApplication

fun main(args: Array<String>) {
    runApplication<GongbaekApplication>(*args)
}
