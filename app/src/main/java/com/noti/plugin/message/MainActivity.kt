package com.noti.plugin.message

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.jacknkiarie.chatui.ChatView
import com.jacknkiarie.chatui.models.ChatMessage
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatView = findViewById<View>(R.id.chat_view) as ChatView
        chatView.setOnSentMessageListener {
            it.chatId = "chat1"
            it.sender = "ddd"
            mainViewModel.saveMessage(it)
            true
        }

        chatView.setTypingListener(object : ChatView.TypingListener {
            override fun userStartedTyping() {}
            override fun userStoppedTyping() {}
        })

        val factory = MainViewModelFactory(this.application)
         mainViewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]

        mainViewModel.getChatMessages().observe(this) { messages ->
            Log.d("TAG", "I AM CALLED WITH DATA: ${messages.snapshot()}")
            if (messages != null) chatView.chatViewListAdapter.submitList(messages)
            chatView.chatViewListAdapter.notifyDataSetChanged()
        }

        generateAndSaveMessages()
    }

    private fun generateAndSaveMessages() {
        val messages = ArrayList<ChatMessage>()
        mainViewModel.saveMessages(messages)
    }
}
