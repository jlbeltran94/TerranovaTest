package solutionsyn.mobile.terranovatest.di.modules

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import solutionsyn.mobile.terranovatest.di.ActivityScope
import solutionsyn.mobile.terranovatest.ui.adapters.OrderAdapter
import solutionsyn.mobile.terranovatest.ui.main.MainActivity
import javax.inject.Named

/**
 * Created by jlbel on 24/09/2017.
 */
@Module
class MainModule {

//    @ActivityScope
//    @Provides
//    @Named("mainActivityContext")
//    fun provideActivityContext(activity: MainActivity):Context = activity

    @ActivityScope
    @Provides
    fun provideAdapter(activity: MainActivity):OrderAdapter = OrderAdapter(activity)



}