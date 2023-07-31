package com.noti.plugin.message

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jacknkiarie.chatui.models.ChatMessage

@Dao
interface MessageDao {
    @Query("SELECT * FROM chat_message_table")
    fun getMessages(): DataSource.Factory<Int, ChatMessage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(myMatch: ChatMessage): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMessages(messages: List<ChatMessage>): List<Long>
}
