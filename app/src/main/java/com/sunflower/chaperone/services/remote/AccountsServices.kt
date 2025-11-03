package com.sunflower.chaperone.services.remote

import com.sunflower.chaperone.domain.model.CommonResponse
import com.sunflower.chaperone.domain.model.accounts.IdVerificationRequest
import com.sunflower.chaperone.domain.model.accounts.UpdateProfileRequest
import com.sunflower.chaperone.domain.model.accounts.UpdateWalkerStatus
import com.sunflower.chaperone.domain.model.accounts.WalkerInfoResponse
import com.sunflower.chaperone.domain.model.accounts.WalkerSummaryResponse
import com.sunflower.chaperone.domain.model.accounts.WandererInfoResponse
import com.sunflower.chaperone.domain.model.accounts.WandererSummaryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface AccountsServices {
    @GET("accounts/walker-info/{walker_id}/")
    suspend fun getWalkerInfo(@Path("walker_id") walkerId: Int): Response<WalkerInfoResponse>

    @GET("accounts/get-wanderer-info/{wanderer_id}/")
    suspend fun getWandererInfo(@Path("wanderer_id") wandererId: Int): Response<WandererInfoResponse>

    @PUT("accounts/users/update/")
    suspend fun idVerification(@Body request: IdVerificationRequest): Response<CommonResponse>


    @PUT("accounts/update-user-profile/")
    suspend fun updateProfile(@Body request: UpdateProfileRequest): Response<CommonResponse>

    @GET("accounts/get-walker-summary/")
    suspend fun getWalkerSummary() : Response<WalkerSummaryResponse>

    @GET("accounts/get-wanderer-summary/")
    suspend fun getWandererSummary(): Response<WandererSummaryResponse>

    @PUT("accounts/update-walker-status/")
    suspend fun updateWalkerStatus(@Body request: UpdateWalkerStatus) : Response<CommonResponse>

}