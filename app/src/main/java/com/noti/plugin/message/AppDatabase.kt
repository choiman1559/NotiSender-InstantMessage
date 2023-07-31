package com.noti.plugin.message

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jacknkiarie.chatui.models.ChatMessage
import com.jacknkiarie.chatui.models.MessageTypeConverter

@Database(entities = [ChatMessage::class], version = 1, exportSchema = false)
@TypeConverters(MessageTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "chat_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}