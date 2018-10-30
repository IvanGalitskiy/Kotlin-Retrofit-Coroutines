package devandfun.com.aac.data

import devandfun.com.aac.model.Post
import devandfun.com.aac.model.Result
import javax.inject.Inject

class FakeService @Inject constructor(val api: FakeApi) : Repository {


    override suspend fun getPosts(): Result<List<Post>> {
        return try {
            val data = api.getPosts().await()
            Result.Success(data)
        } catch (ex: Throwable) {
            Result.Error(ex)
        }
    }
}