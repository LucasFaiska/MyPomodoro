package com.lfaiska.mypomodoro

import android.app.Application
import com.lfaiska.mypomodoro.presenter.dependencyInjection.components.AppComponent
import com.lfaiska.mypomodoro.presenter.dependencyInjection.components.DaggerAppComponent
import com.lfaiska.mypomodoro.presenter.dependencyInjection.modules.AppModule

/**
 * Created by lucas on 30/03/18.
 */

class MainApplication: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}