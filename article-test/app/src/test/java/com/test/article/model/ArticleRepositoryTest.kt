package com.test.article.model

import com.test.article.network.ArticleService
import com.test.article.network.RetrofitClient
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

@RunWith(MockitoJUnitRunner::class)

class ArticleRepositoryTest{
    @InjectMocks
    lateinit var subject:  ArticleRepository

    @Mock
    lateinit var articleService: ArticleService

    @Test
    fun getMutableLiveData(){
        // verify something here. will do later

    }
}
