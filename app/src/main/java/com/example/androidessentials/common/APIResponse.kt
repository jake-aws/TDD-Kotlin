package com.example.androidessentials.common

import retrofit2.Response

data class APIResponse<T>(
    val status: Status, val data: Response<T>?, val exception: Exception?
) {

    sealed class Status {
        object Success : Status()
        object Failure : Status()
    }


    val failed: Boolean
        get() = this.status == Status.Failure

    val isSuccessful: Boolean
        get() = !failed && this.data?.isSuccessful == true

    val body: T
        get() = this.data!!.body()!!

    companion object {
        fun <T> success(data: Response<T>): APIResponse<T> {
            return APIResponse(status = Status.Success, data = data, exception = null)
        }

        fun <T> failure(exception: Exception?): APIResponse<T> {
            return APIResponse(status = Status.Failure, data = null, exception = exception)
        }

    }

}