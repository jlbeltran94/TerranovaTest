package solutionsyn.mobile.terranovatest.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import solutionsyn.mobile.terranovatest.R
import javax.inject.Singleton

/**
 * Created by jlbel on 24/09/2017.
 */
@Module
class NetModule{

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
            .setDateFormat("dd/MM/yyyy")
            .create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, context:Context): Retrofit = Retrofit.
            Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(context.getString(R.string.baseUrl))
            .build()
}