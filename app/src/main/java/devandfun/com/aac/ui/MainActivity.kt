package devandfun.com.aac.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import devandfun.com.aac.R
import devandfun.com.aac.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {
    @Inject
    lateinit var vmFactory: ViewModelFactory

    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        postsViewModel = ViewModelProviders.of(this, vmFactory).get(PostsViewModel::class.java)


        postsViewModel.apply {
            posts.observe(this@MainActivity, Observer {
                vText.text = ""
                it?.forEach { elem ->
                    vText.append(elem.toString())
                }
            })
            exception.observe(this@MainActivity, Observer {
                vError.visibility = if (it != null) View.VISIBLE else View.INVISIBLE
            })
        }


        postsViewModel.load()
    }
}
