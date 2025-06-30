package gongbaek.api.common

import org.springframework.http.HttpStatus

data class ResponseError(
    val code: Int,
    val message: String
) {
    val httpStatus: HttpStatus
        get() = HttpStatus.valueOf(code / 10)

    companion object {
        val BAD_REQUEST = ResponseError(4000, "유효하지 않은 요청입니다.")
        val INVALID_INPUT_VALUE = ResponseError(4001, "검증에 실패하였습니다.")
        val INVALID_REQUEST_PARAMETER = ResponseError(4008, "요청 파라미터가 잘못되었습니다.")

        val UNAUTHORIZED_ACCESS = ResponseError(4010, "리소스 접근 권한이 없습니다.")
        val INVALID_TOKEN = ResponseError(4011, "액세스 토큰의 값이 올바르지 않습니다.")
        val EXPIRED_TOKEN = ResponseError(4012, "액세스 토큰이 만료되었습니다. 재발급 받아주세요.")

        val NOT_FOUND = ResponseError(4040, "대상을 찾을 수 없습니다.")
        val USER_NOT_FOUND = ResponseError(4042, "유저를 찾을 수 없습니다.")

        val CONFLICT = ResponseError(4090, "이미 존재하는 리소스 입니다.")

        val INTERNAL_SERVER_ERROR = ResponseError(5000, "서버 내부 오류입니다.")
    }
}
