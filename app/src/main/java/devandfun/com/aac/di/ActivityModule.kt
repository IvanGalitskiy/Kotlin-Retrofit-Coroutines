package devandfun.com.aac.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import devandfun.com.aac.ui.MainActivity

@Module(includes = [AndroidInjectionModule::class])
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [NetworkModule::class])
    abstract fun bindMainActivity (): MainActivity
}