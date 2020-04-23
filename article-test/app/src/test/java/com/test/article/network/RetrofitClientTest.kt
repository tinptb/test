package com.test.article.network

import com.test.article.model.ArticleRepository
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class RetrofitClientTest{

    @InjectMocks
    lateinit var subject:  RetrofitClient


    @Test
    fun getMutableLiveData(){
        // verify something here. will do later

    }
}
