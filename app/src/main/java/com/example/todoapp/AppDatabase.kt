package com.example.todoapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [TodoModel::class],version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun todoDao():TodoDao

    companion object {
// Singleton prevents multiple instances of database opening at the same time

        @Volatile
        private var INSTANCE:AppDatabase?=null


        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context):AppDatabase {
            val tempInstance = INSTANCE
            if(tempInstance!=null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME

                ).build()
                INSTANCE=instance
                return instance
            }

        }

    }
}