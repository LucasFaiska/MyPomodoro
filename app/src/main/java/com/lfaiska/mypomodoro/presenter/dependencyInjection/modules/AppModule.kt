package com.lfaiska.mypomodoro.presenter.dependencyInjection.modules

import android.app.Application
import android.content.Context
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

/**
 * Created by lucas on 30/03/18.
 */

@Module
class AppModule(private val app: Application) {

    @Provides @Singleton
    fun provideApplication(): Application = app

    @Provides @Singleton
    fun provideApplicationContext(): Context = app

    /*@Provides @Singleton
    fun provideBookRepository(bookDataRepository: BookDataRepository): BookRepository {
        return bookDataRepository;
    }*/
}