package com.dickyalifya.mysimplecleanarchitecture.data

import com.dickyalifya.mysimplecleanarchitecture.domain.IMessageRepository
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageEntity

class MessageRepository(private val messageDataSource: IMessageDataSource) : IMessageRepository {

    override fun getWelcomeMessage(name: String) = messageDataSource.getMessageFromSource(name)

}