package victorteka.github.io.koin_tutorial.di.module

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import victorteka.github.io.koin_tutorial.BuildConfig
import victorteka.github.io.koin_tutorial.data.api.ApiHelper
import victorteka.github.io.koin_tutorial.data.api.ApiHelperImpl
import victorteka.github.io.koin_tutorial.data.api.ApiService
import victorteka.github.io.koin_tutorial.utils.Constants
import victorteka.github.io.koin_tutorial.utils.NetworkHelper

private fun provideNetWorkHelper(context: Context)= NetworkHelper(context)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG){
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}else OkHttpClient.Builder().build()

private fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit=
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)

private fun provideApiHelperImpl(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

val appModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), Constants.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetWorkHelper(androidContext()) }
}