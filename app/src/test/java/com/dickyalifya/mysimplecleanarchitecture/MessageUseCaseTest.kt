package com.dickyalifya.mysimplecleanarchitecture

import com.dickyalifya.mysimplecleanarchitecture.domain.IMessageRepository
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageEntity
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageInteractor
import com.dickyalifya.mysimplecleanarchitecture.domain.MessageUseCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MessageUseCaseTest {

    private lateinit var messageUseCase: MessageUseCase

    @Mock private lateinit var messageRepository: IMessageRepository

    companion object {
        const val NAME = "Alifya Putri Aisyka"
    }

    @Before
    fun setUp() {
        messageUseCase = MessageInteractor(messageRepository)
        val dummyMessage = MessageEntity("""
            Hello $NAME, You're Great
            You're the best
            you can be android developer
            you can be anything 
            YOU WANT !
        """.trimIndent())
        `when`(messageRepository.getWelcomeMessage(NAME)).thenReturn(dummyMessage)
    }

    @Test fun `should get data from repository`() {
        val message = messageUseCase.getMessage(NAME)

        verify(messageRepository).getWelcomeMessage(NAME)
        verifyNoMoreInteractions(messageRepository)
        Assert.assertEquals("""
            Hello $NAME, You're Great
            You're the best
            you can be android developer
            you can be anything 
            YOU WANT !
        """.trimIndent(),message.welcomeMessage)
    }

}