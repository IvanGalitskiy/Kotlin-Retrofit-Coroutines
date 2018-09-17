package devandfun.com.aac.model

sealed class Result<out T>{
     data class Success<T>(val items:T):Result<T>()
     data class Error<Throwable>(val error:Throwable):Result<Nothing>()
 }