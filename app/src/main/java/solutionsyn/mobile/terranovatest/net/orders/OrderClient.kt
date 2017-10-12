package solutionsyn.mobile.terranovatest.net.orders

import io.reactivex.Flowable

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import solutionsyn.mobile.terranovatest.data.models.Order
import solutionsyn.mobile.terranovatest.net.responses.SimpleResponse

/**
 * Created by jlbel on 24/09/2017.
 */
interface OrderClient {

    @GET("preorders")
    fun allOrders() : Flowable<List<Order>>

    @GET("preorders/estado/{status}")
    fun byStatus(@Path("status") status: Boolean): Flowable<List<Order>>

    @DELETE("preorders/{id}")
    fun delete(@Path("id") id: String): Flowable<SimpleResponse>


}