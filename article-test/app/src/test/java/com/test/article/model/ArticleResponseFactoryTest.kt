package com.test.article.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class ArticleResponseFactoryTest {

    @InjectMocks
    lateinit var subject: ArticleResponseFactoryWrapper

    @Test
    fun getMutableLiveData_giveTimeWithLong_returnCorrectDateWithFormat() {
        val time = 1587739434L
        val actual = subject.convertLongToDate(time)
        assertEquals(actual, "2020-04-24")
    }

    @Test
    fun getMutableLiveData_giveTimeWithLong_returnWrongDateWithFormat() {
        val time = 1587739434L
        val actual = subject.convertLongToDate(time)
        assertNotEquals(actual, "2020-04-20")
    }
}
