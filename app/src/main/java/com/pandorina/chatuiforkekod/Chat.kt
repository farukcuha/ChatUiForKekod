package com.pandorina.chatuiforkekod

import java.text.DateFormat
import java.util.*

data class Chat(val text: String,
                val timeStamp: Long,
                val isThisMine: Boolean){
    val time: String
        get() = DateFormat.getTimeInstance(DateFormat.SHORT).format(Date(timeStamp))
}
