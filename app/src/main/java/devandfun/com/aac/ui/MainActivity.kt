package devandfun.com.aac.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import devandfun.com.aac.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel::class.java)

        postsViewModel.apply {
            posts.observe(this@MainActivity, Observer {
                vText.text =""
                it?.forEach { elem ->
                    vText.append(elem.toString())
                }
            })
            exception.observe(this@MainActivity, Observer {
                vError.visibility = if (it!=null) View.VISIBLE else View.INVISIBLE
            })
        }

        postsViewModel.load()
    }
}
