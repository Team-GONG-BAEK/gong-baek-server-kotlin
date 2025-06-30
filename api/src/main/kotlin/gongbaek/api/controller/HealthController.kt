package gongbaek.api.controller

import gongbaek.api.common.ResponseBuilder
import gongbaek.api.common.ResponseError
import gongbaek.api.exception.GongbaekException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/health")
class HealthController {
    @GetMapping
    fun healthCheck() = ResponseBuilder.ok("Server is Healthy")

    @GetMapping("/create")
    fun createHealthCheck() = ResponseBuilder.created(1)

    @GetMapping("/error-test")
    fun errorTest(): Nothing {
        throw GongbaekException(ResponseError.BAD_REQUEST)
    }

    @GetMapping("/exception-test")
    fun exceptionTest(): Nothing {
        throw RuntimeException("runtime!!!")
    }
}