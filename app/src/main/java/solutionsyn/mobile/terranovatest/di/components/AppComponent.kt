package solutionsyn.mobile.terranovatest.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import solutionsyn.mobile.terranovatest.App
import solutionsyn.mobile.terranovatest.di.ActivityBuilders
import solutionsyn.mobile.terranovatest.di.modules.AppModule
import solutionsyn.mobile.terranovatest.di.modules.NetModule
import javax.inject.Singleton

/**
 * Created by jlbel on 24/09/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilders::class,
        NetModule::class
))
interface AppComponent{

    fun inject(app: App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application):Builder
        fun build():AppComponent
    }
}