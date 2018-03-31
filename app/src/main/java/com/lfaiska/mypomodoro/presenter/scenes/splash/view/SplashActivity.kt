package com.lfaiska.mypomodoro.presenter.scenes.splash.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lfaiska.mypomodoro.MainApplication
import com.lfaiska.mypomodoro.R
import com.lfaiska.mypomodoro.presenter.scenes.splash.viewModel.SplashViewModel
import android.databinding.DataBindingUtil
import com.lfaiska.mypomodoro.databinding.SplashActivityBinding
import com.lfaiska.mypomodoro.presenter.scenes.home.view.HomeActivity
import javax.inject.Inject

/**
 * Created by lucas on 30/03/18.
 */

class SplashActivity : AppCompatActivity(), SplashNavigation {

    @Inject
    lateinit var viewModel: SplashViewModel

    private lateinit var binding: SplashActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity)
        viewModel.navigation = this
        binding.viewModel = viewModel
        viewModel.init()
    }

    override fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    fun injectDependencies() {
        MainApplication.appComponent.inject(this)
    }
}