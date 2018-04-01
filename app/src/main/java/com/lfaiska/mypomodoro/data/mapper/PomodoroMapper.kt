package com.lfaiska.mypomodoro.data.mapper

import com.lfaiska.mypomodoro.data.entitity.PomodoroRealmEntity
import com.lfaiska.mypomodoro.domain.Pomodoro

/**
 * Created by lucas on 01/04/18.
 */

class PomodoroMapper {

    companion object {
        fun toListDomainObject(realmEntityList: List<PomodoroRealmEntity>): List<Pomodoro> {
            return realmEntityList?.map { toDomainObject(it) }
        }

        fun toDomainObject(realmEntity: PomodoroRealmEntity): Pomodoro {
            with(realmEntity) {
                return Pomodoro(runningTime, endTime, status)
            }
        }

        fun toRealmEntity(pomodoro: Pomodoro, id: Long): PomodoroRealmEntity {
            with(pomodoro) {
                return PomodoroRealmEntity(id, runningTime, endTime, status)
            }
        }
    }
}