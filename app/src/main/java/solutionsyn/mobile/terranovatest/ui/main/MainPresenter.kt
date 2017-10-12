package solutionsyn.mobile.terranovatest.ui.main

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import solutionsyn.mobile.terranovatest.data.models.Order
import solutionsyn.mobile.terranovatest.di.ActivityScope
import solutionsyn.mobile.terranovatest.net.orders.OrderClient
import solutionsyn.mobile.terranovatest.util.push
import javax.inject.Inject

/**
 * Created by jlbel on 24/09/2017.
 */
@ActivityScope
class MainPresenter @Inject constructor(retrofit: Retrofit){

    val dis: CompositeDisposable = CompositeDisposable()
    val orderClient:OrderClient = retrofit.create(OrderClient::class.java)

    fun bind(view: MainView){

        dis push view.onClickOrder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{view.showToast(it.client.nombre)}
        dis push view.onClickDeleteOrder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{view.showToast("delete ${it.client.nombre}")}
        dis push view.onClickEditOrder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{view.showToast("edit ${it.client.nombre}")}
        dis push view.onClickFinishOrder()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{view.showToast("finish ${it.client.nombre}")}
        dis push view.onClickAdd()
                .subscribe { view.goToAdd() }

    }

    fun undind(){
        dis.dispose()
    }

    fun getAllOrders():Flowable<List<Order>> = orderClient.allOrders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}