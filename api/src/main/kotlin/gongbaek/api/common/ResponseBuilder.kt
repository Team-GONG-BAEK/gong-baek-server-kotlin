package gongbaek.api.common

import org.springframework.http.ResponseEntity

object ResponseBuilder {
    fun <T> ok(data: T): ResponseEntity<ApiResponse<T>> =
        ResponseEntity.ok(ApiResponse.success(ResponseSuccess.OK, data))

    fun <T> created(data: T): ResponseEntity<ApiResponse<T>> =
        ResponseEntity.status(201).body(ApiResponse.success(ResponseSuccess.CREATED, data))

    fun error(responseError: ResponseError): ResponseEntity<ApiResponse<Void>> =
        ResponseEntity.status(responseError.httpStatus)
            .body(ApiResponse.error(responseError))
}