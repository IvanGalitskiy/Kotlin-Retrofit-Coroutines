package devandfun.com.aac.di

import dagger.BindsInstance
import dagger.Component
import devandfun.com.aac.Application
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ActivityModule::class, ViewModelModule::class])
interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun app(app: Application):Builder
        fun build():AppComponent
    }
    fun inject(app:Application)
}