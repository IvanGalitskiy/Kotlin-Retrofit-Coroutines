package devandfun.com.aac.data

import devandfun.com.aac.model.Post
import devandfun.com.aac.model.Result

interface Repository {
   suspend fun getPosts(): Result<List<Post>>
}