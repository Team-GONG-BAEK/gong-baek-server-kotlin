package gongbaek.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GongbaekApplication

fun main(args: Array<String>) {
    runApplication<GongbaekApplication>(*args)
}
