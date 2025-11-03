package com.sunflower.chaperone.di

import com.sunflower.chaperone.data.local.appPref.AppPref
import com.sunflower.chaperone.services.remote.AccountsServices
import com.sunflower.chaperone.services.remote.AuthServices
import com.sunflower.chaperone.services.remote.FeedbackServices
import com.sunflower.chaperone.services.remote.PaymentServices
import com.sunflower.chaperone.services.remote.RequestsServices
import com.sunflower.chaperone.services.remote.SearchServices
import com.sunflower.chaperone.services.remote.WalksServices
import com.sunflower.chaperone.utils.Constants
import com.sunflower.chaperone.utils.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    private val okHttpClient by lazy {
        OkHttpClient
            .Builder()
            .build()
    }

    private fun constructRetrofit(appPreferences: AppPref): Retrofit =
        Retrofit.Builder()
            .client(
                okHttpClient
                    .newBuilder()
                    .addInterceptor(HeaderInterceptor(appPreferences))
                    // .addInterceptor (HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
                    .build(),
            )
            .baseUrl(Constants.CHAPERONE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideSearchServices(appPreferences: AppPref): SearchServices =
        constructRetrofit(appPreferences)
            .create(SearchServices::class.java)

    @Singleton
    @Provides
    fun provideAccountsServices(appPreferences: AppPref): AccountsServices =
        constructRetrofit(appPreferences)
            .create(AccountsServices::class.java)

    @Singleton
    @Provides
    fun provideRequestsServices(appPreferences: AppPref): RequestsServices =
        constructRetrofit(appPreferences)
            .create(RequestsServices::class.java)

    @Singleton
    @Provides
    fun provideAuthServices(appPreferences: AppPref): AuthServices =
        constructRetrofit(appPreferences)
            .create(AuthServices::class.java)

    @Singleton
    @Provides
    fun providePaymentServices(appPreferences: AppPref): PaymentServices =
        constructRetrofit(appPreferences)
            .create(PaymentServices::class.java)

    @Singleton
    @Provides
    fun provideWalksServices(appPreferences: AppPref): WalksServices =
        constructRetrofit(appPreferences)
            .create(WalksServices::class.java)

    @Singleton
    @Provides
    fun provideFeedbackServices(appPreferences: AppPref): FeedbackServices =
        constructRetrofit(appPreferences)
            .create(FeedbackServices::class.java)


}