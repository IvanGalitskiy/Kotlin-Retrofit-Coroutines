package devandfun.com.aac.data

import devandfun.com.aac.model.Post
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface FakeApi {
    @GET("posts/")
    fun getPosts(): Deferred<List<Post>>
}