package solutionsyn.mobile.terranovatest.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import solutionsyn.mobile.terranovatest.di.modules.MainModule
import solutionsyn.mobile.terranovatest.ui.main.MainActivity
import javax.inject.Scope

/**
 * Created by jlbel on 24/09/2017.
 */
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity



}