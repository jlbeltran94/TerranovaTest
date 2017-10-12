package solutionsyn.mobile.terranovatest.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

import solutionsyn.mobile.terranovatest.R
import solutionsyn.mobile.terranovatest.data.models.Order
import solutionsyn.mobile.terranovatest.ui.adapters.OrderAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var adapter:OrderAdapter

    @Inject
    lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        presenter.getAllOrders()
                .subscribe{adapter.data = it}
        presenter.bind(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.undind()
    }

    override fun onClickOrder(): Observable<Order> = adapter.clickOrderSubject

    override fun onClickDeleteOrder(): Observable<Order> = adapter.deleteOrderSubject

    override fun onClickEditOrder(): Observable<Order> = adapter.editOrderSubject

    override fun onClickFinishOrder(): Observable<Order> = adapter.finishOrderSubject


    override fun goToAdd() {
        toast("goToAdd")
    }

    override fun onClickAdd(): Observable<Unit> = add.clicks()

    override fun showToast(msg: String) {
        toast(msg)
    }



}
