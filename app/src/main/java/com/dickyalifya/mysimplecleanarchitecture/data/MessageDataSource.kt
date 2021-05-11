package com.dickyalifya.mysimplecleanarchitecture.data

import com.dickyalifya.mysimplecleanarchitecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromSource(name: String): MessageEntity = MessageEntity("""
        Hello $name, You're Great
        You're the best
        you can be android developer
        you can be anything 
        YOU WANT !
""".trimIndent())
}