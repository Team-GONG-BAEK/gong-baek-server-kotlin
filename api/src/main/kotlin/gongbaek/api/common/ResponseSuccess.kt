package gongbaek.api.common

data class ResponseSuccess(
    val code: Int,
    val message: String,
) {
    companion object {
        val OK = ResponseSuccess(200, "성공하였습니다.")
        val CREATED = ResponseSuccess(201, "리소스가 성공적으로 생성되었습니다.")
    }
}