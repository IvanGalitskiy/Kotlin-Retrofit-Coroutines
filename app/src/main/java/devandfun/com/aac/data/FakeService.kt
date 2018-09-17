package devandfun.com.aac.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import devandfun.com.aac.model.Post
import devandfun.com.aac.model.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeService : Repository {


    val api: FakeApi
    fun init(): FakeApi {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

        return retrofit.create(FakeApi::class.java)
    }

    init {
        api = init()
    }

    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val data = api.getPosts().await()
            Result.Success(data)
        } catch (ex: Throwable) {
            Result.Error(ex)
        }
    }
}