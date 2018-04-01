package com.lfaiska.mypomodoro.presenter.dependencyInjection.modules

import android.app.Application
import android.content.Context
import com.lfaiska.mypomodoro.data.repository.PomodoroRealmRepository
import com.lfaiska.mypomodoro.domain.repository.PomodoroRepository
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import io.realm.Realm

/**
 * Created by lucas on 30/03/18.
 */

@Module
class AppModule(private val app: Application) {

    @Provides @Singleton
    fun provideApplication(): Application = app

    @Provides @Singleton
    fun provideApplicationContext(): Context = app

    @Provides @Singleton
    fun provideRealm(): Realm {
        Realm.init(provideApplicationContext())
        return Realm.getDefaultInstance()
    }

    @Provides @Singleton
    fun providePomodoroRepository(pomodoroRealmRepository: PomodoroRealmRepository): PomodoroRepository {
        return pomodoroRealmRepository;
    }
}