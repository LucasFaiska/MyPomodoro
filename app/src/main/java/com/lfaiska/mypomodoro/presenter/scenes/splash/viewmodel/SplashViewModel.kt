package com.lfaiska.mypomodoro.presenter.scenes.splash.viewmodel

import com.lfaiska.mypomodoro.presenter.scenes.splash.view.SplashNavigation
import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class SplashViewModel @Inject constructor() {

    companion object {
        val SPLASH_SCREEN_SECONDS_DELAY: Long = 3
    }

    lateinit var navigation: SplashNavigation

    fun init() {
        Completable.complete().delay(SPLASH_SCREEN_SECONDS_DELAY, TimeUnit.SECONDS)
                .doOnComplete { navigation.navigateToHome() }
                .subscribe()
    }
}
