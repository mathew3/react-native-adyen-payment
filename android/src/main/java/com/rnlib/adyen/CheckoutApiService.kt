package com.rnlib.adyen

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.GET
import com.rnlib.adyen.PaymentMethodsRequest

interface CheckoutApiService {
    @GET("payment/adyen/payment-methods?channel=Android")
    fun paymentMethods(@HeaderMap headerMap: Map<String, String>,
        @Query("countryCode") String countryCode,
        @Query("amount[currency]") String amountCurrency,
        @Query("amount[value]") String amountValue,
        @Query("shopperLocale") String shopperLocale): Call<ResponseBody>

    @POST("orders")
    fun payments(@HeaderMap headerMap: Map<String, String>,@Body paymentsRequest: RequestBody): Call<ResponseBody>

    @POST("payments/details")
    fun details(@HeaderMap headerMap: Map<String, String>,@Body detailsRequest: RequestBody): Call<ResponseBody>
}
