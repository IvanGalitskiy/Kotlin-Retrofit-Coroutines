package devandfun.com.aac.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import devandfun.com.aac.data.FakeService
import devandfun.com.aac.model.Post
import devandfun.com.aac.model.Result
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch

class PostsViewModel : ViewModel() {
    val posts = MutableLiveData<List<Post>>()
    val exception = MutableLiveData<Throwable>()


    fun load() = GlobalScope.launch{
        val res = FakeService().getPosts()
        if (res is Result.Success){
            exception.postValue(null)
            posts.postValue(res.items)
        } else if (res is Result.Error) {
            exception.postValue(res.error)
        }
    }


}