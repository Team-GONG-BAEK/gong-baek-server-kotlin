package gongbaek.api.exception

import gongbaek.api.common.ApiResponse
import gongbaek.api.common.ResponseBuilder
import gongbaek.api.common.ResponseError
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(GongbaekException::class)
    fun handleGongbaekException(e: GongbaekException): ResponseEntity<ApiResponse<Void>> {
        log.error("GongbaekException occurred", e)
        return ResponseBuilder.error(e.responseError)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Void>> {
        log.error("MethodArgumentNotValidException occurred", e)
        return ResponseBuilder.error(ResponseError.BAD_REQUEST)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(e: HttpMessageNotReadableException): ResponseEntity<ApiResponse<Void>> {
        log.error("HttpMessageNotReadableException occurred", e)
        return ResponseBuilder.error(ResponseError.BAD_REQUEST)
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun handleMissingServletRequestParameterException(e: MissingServletRequestParameterException): ResponseEntity<ApiResponse<Void>> {
        log.error("MissingServletRequestParameterException occurred", e)
        return ResponseBuilder.error(ResponseError.INVALID_REQUEST_PARAMETER)
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<ApiResponse<Void>> {
        log.error("Unhandled Exception occurred", e)
        return ResponseBuilder.error(ResponseError.INTERNAL_SERVER_ERROR)
    }
}
