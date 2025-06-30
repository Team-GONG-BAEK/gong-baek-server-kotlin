package gongbaek.api.exception

import gongbaek.api.common.ResponseError

class GongbaekException (
    val responseError: ResponseError
) : RuntimeException(responseError.message)