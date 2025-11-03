package com.sunflower.chaperone.services.remote

import com.sunflower.chaperone.domain.model.search.SearchWalkerRequest
import com.sunflower.chaperone.domain.model.search.SearchWalkerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SearchServices {

    @POST("search/search_companion/")
    suspend fun searchWalkers(
        @Body request: SearchWalkerRequest
    ): Response<SearchWalkerResponse>
}