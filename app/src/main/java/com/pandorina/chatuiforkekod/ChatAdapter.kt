package com.pandorina.chatuiforkekod

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pandorina.chatuiforkekod.databinding.ItemChatBubbleIncomingBinding
import com.pandorina.chatuiforkekod.databinding.ItemChatBubbleOutgoingBinding

class ChatAdapter(private val chatList: List<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class IncomingChatItemHolder(private val binding: ItemChatBubbleIncomingBinding) :
        RecyclerView.ViewHolder(binding.root), BindRecyclerItem {

        override fun bind(item: Chat) {
            binding.tvTextIncoming.text = item.text
            binding.tvTimestampIncoming.text = item.time
        }
    }

    class OutgoingChatItemHolder(private val binding: ItemChatBubbleOutgoingBinding) :
        RecyclerView.ViewHolder(binding.root), BindRecyclerItem {

        override fun bind(item: Chat) {
            binding.tvTextOutgoing.text = item.text
            binding.tvTimestampOutgoing.text = item.time
        }
    }

    interface BindRecyclerItem{
        fun bind(item: Chat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ChatBubbleType.OUTGOING.ordinal) {
            OutgoingChatItemHolder(
                ItemChatBubbleOutgoingBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )
        } else {
            IncomingChatItemHolder(
                ItemChatBubbleIncomingBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = chatList[position]
        when (holder) {
            is IncomingChatItemHolder -> {
                holder.bind(item)
            }
            is OutgoingChatItemHolder -> {
                holder.bind(item)
            }
            else -> return
        }
    }

    override fun getItemCount(): Int = chatList.size

    override fun getItemViewType(position: Int): Int {
        val chatItem = chatList[position]
        return if (chatItem.isThisMine) {
            ChatBubbleType.OUTGOING.ordinal
        } else {
            ChatBubbleType.INCOMING.ordinal
        }
    }
}

enum class ChatBubbleType {
    INCOMING, OUTGOING
}