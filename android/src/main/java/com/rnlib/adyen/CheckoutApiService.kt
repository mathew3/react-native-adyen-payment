package com.rnlib.adyen

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.Query
import retrofit2.http.POST
import retrofit2.http.GET
import com.rnlib.adyen.PaymentMethodsRequest

interface CheckoutApiService {
    @GET("payment/adyen/payment-methods?channel=Android")
    fun paymentMethods(@HeaderMap headerMap: Map<String, String>,
        @Query("countryCode") countryCode: String,
        @Query("amount[currency]") amountCurrency: String,
        @Query("amount[value]") amountValue: Int,
        @Query("shopperLocale") shopperLocale: String): Call<ResponseBody>

    @POST("orders")
    fun payments(@HeaderMap headerMap: Map<String, String>,@Body paymentsRequest: RequestBody): Call<ResponseBody>

    @POST("payments/details")
    fun details(@HeaderMap headerMap: Map<String, String>,@Body detailsRequest: RequestBody): Call<ResponseBody>
}
