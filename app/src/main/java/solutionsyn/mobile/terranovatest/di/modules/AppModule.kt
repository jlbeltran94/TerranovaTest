package solutionsyn.mobile.terranovatest.di.modules

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jlbel on 24/09/2017.
 */
@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun providePreference(context: Context): SharedPreferences =
            context.getSharedPreferences("TerranovaPreferences", Activity.MODE_PRIVATE)


}