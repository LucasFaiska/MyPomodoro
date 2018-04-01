package com.lfaiska.mypomodoro.data.entitity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date

/**
 * Created by lucas on 31/03/18.
 */

open class PomodoroRealmEntity(
        @PrimaryKey
        var id: Long = 0,
        var runningTime: Long = 0,
        var endTime: Date? = null,
        var status: Int = 0
) : RealmObject()