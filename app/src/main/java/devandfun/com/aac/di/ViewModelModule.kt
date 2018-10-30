package devandfun.com.aac.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import devandfun.com.aac.ui.PostsViewModel
import devandfun.com.aac.viewmodel.ViewModelFactory
import devandfun.com.aac.viewmodel.ViewModelKey


@Module(includes = [NetworkModule::class])
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    internal abstract fun postListViewModel(viewModel: PostsViewModel): ViewModel

    //Add more ViewModels here
}