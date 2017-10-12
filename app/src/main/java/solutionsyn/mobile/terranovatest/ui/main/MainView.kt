package solutionsyn.mobile.terranovatest.ui.main

import io.reactivex.Observable
import solutionsyn.mobile.terranovatest.data.models.Order

/**
 * Created by jlbel on 24/09/2017.
 */
interface MainView{

    fun onClickOrder():Observable<Order>
    fun onClickDeleteOrder():Observable<Order>
    fun onClickEditOrder():Observable<Order>
    fun onClickFinishOrder():Observable<Order>
    fun onClickAdd():Observable<Unit>
    fun goToAdd()
    fun showToast(msg:String)
}