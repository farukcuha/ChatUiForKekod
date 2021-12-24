package com.pandorina.chatuiforkekod

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pandorina.chatuiforkekod.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatList = listOf(
            Chat("Why did you try to destroy half of the universe?", 1640347288, false),
            Chat("I had to do that son! Do you have a problem?", 1640348160, true),
            Chat("Yes, there is a big problem.", 1640348960, false),
            Chat("What is that?", 1640347421, true),
            Chat("I am dead because of your awful destroying half of universe plan.", 1640347500, false),
            Chat("Don't worry. Thor cut my purple head. You are talking with a titan who has not purple head.", 1640347632, true),
            Chat("I know that.", 1640347798, false),
            Chat("Ok.", 1640347798, true),
            Chat("What!", 1640347798, true),
            Chat("How could you know that?", 1640347900, true)
        )

        val lm = LinearLayoutManager(this@MainActivity)
        lm.stackFromEnd = true

        binding.rvChat.apply {
            setHasFixedSize(true)
            layoutManager = lm
            adapter = ChatAdapter(chatList)
        }
    }
}