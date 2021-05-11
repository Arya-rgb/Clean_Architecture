package com.dickyalifya.mysimplecleanarchitecture.data

import com.dickyalifya.mysimplecleanarchitecture.domain.MessageEntity

interface IMessageDataSource {

    fun getMessageFromSource(name: String): MessageEntity

}