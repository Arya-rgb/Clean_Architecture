package com.dickyalifya.mysimplecleanarchitecture.di

import com.dickyalifya.mysimplecleanarchitecture.data.IMessageDataSource
import com.dickyalifya.mysimplecleanarchitecture.data.MessageDataSource
import com.dickyalifya.mysimplecleanarchitecture.data.MessageRepository
import com.dickyalifya.mysimplecleanarchitecture.domain.IMessageRepository
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageInteractor
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageUseCase

object Injection {

    fun provideUseCause(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }

}