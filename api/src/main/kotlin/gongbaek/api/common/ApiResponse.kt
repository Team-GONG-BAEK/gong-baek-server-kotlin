package gongbaek.api.common

data class ApiResponse<T>(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: T?
) {
    companion object {
        fun <T> success(responseSuccess: ResponseSuccess, data: T): ApiResponse<T> =
            ApiResponse(true, responseSuccess.code, responseSuccess.message, data)

        fun <T> error(responseError: ResponseError): ApiResponse<T> =
            ApiResponse(false, responseError.code, responseError.message, null)
    }
}