package com.alef.data.source.local

import android.content.Context
import androidx.room.Room

object DataBaseBuilder {

    private var INSTANCE: DBContext? = null

    fun getInstance(context: Context): DBContext {
        if (INSTANCE == null) {
            synchronized(DBContext::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            DBContext::class.java,
            "Database.db"
        ).build()

}