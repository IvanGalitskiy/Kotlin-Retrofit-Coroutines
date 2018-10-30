package devandfun.com.aac.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import devandfun.com.aac.data.FakeApi
import devandfun.com.aac.data.FakeService
import devandfun.com.aac.data.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun repo(api:FakeApi): Repository {
        return FakeService(api)
    }
    @Singleton
    @Provides
    fun fakeApi(retrofit: Retrofit): FakeApi {
        return retrofit.create(FakeApi::class.java)
    }

    @Singleton
    @Provides
    fun gsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun Retroft(@Named("serverUrl") baseUrl: String,
                gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(gsonConverterFactory)
                .baseUrl(baseUrl)
                .build()

    }
    @Singleton
    @Provides
    @Named("serverUrl")
    fun serverUrl(): String {
        return "https://jsonplaceholder.typicode.com/";
    }


}