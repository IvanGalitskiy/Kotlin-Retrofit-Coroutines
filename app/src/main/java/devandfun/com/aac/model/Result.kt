package devandfun.com.aac.model

sealed class Result<out V>{
     data class Success<V>(val items:V):Result<V>()
     data class Error(val error:kotlin.Throwable):Result<Nothing>()
 }