package com.lfaiska.mypomodoro.presenter.dependencyInjection.components

import com.lfaiska.mypomodoro.MainApplication
import com.lfaiska.mypomodoro.presenter.dependencyInjection.modules.AppModule
import com.lfaiska.mypomodoro.presenter.scenes.splash.view.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lucas on 30/03/18.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: MainApplication)
    fun inject(splashActivity: SplashActivity)
}