package solutionsyn.mobile.terranovatest

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import solutionsyn.mobile.terranovatest.di.components.AppComponent
import solutionsyn.mobile.terranovatest.di.components.DaggerAppComponent
import javax.inject.Inject

/**
 * Created by jlbel on 24/09/2017.
 */
class App: Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>
            = injector

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}