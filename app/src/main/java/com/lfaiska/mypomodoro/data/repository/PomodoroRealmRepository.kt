package com.lfaiska.mypomodoro.data.repository

import com.lfaiska.mypomodoro.data.entitity.PomodoroRealmEntity
import com.lfaiska.mypomodoro.data.mapper.PomodoroMapper
import com.lfaiska.mypomodoro.domain.Pomodoro
import com.lfaiska.mypomodoro.domain.repository.PomodoroRepository
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by lucas on 31/03/18.
 */

@Singleton
class PomodoroRealmRepository @Inject constructor(var realm: Realm): PomodoroRepository {

    override fun getHistory(): List<Pomodoro>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(pomodoro: Pomodoro) {
        realm.beginTransaction()
        realm.insert(PomodoroMapper.toRealmEntity(pomodoro, getNextID()))
        realm.commitTransaction()
    }

    private fun getNextID(): Long {
        val currentIdNum = realm.where(PomodoroRealmEntity::class.java).max("id")
        return if (currentIdNum == null) 1 else currentIdNum.toLong() + 1
    }
}