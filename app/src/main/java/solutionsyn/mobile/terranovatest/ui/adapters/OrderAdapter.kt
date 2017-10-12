package solutionsyn.mobile.terranovatest.ui.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.reactivex.subjects.PublishSubject
import solutionsyn.mobile.terranovatest.R
import solutionsyn.mobile.terranovatest.data.models.Order
import solutionsyn.mobile.terranovatest.databinding.TemplateOrderBinding
import solutionsyn.mobile.terranovatest.util.inflate

/**
 * Created by jlbel on 24/09/2017.
 */
class OrderAdapter (var context: Context) : RecyclerView.Adapter<OrderAdapter.OrderHolder>(){



//    lateinit var context:Context

    var data:List<Order> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    val clickOrderSubject: PublishSubject<Order> = PublishSubject.create()
    val deleteOrderSubject: PublishSubject<Order> = PublishSubject.create()
    val editOrderSubject: PublishSubject<Order> = PublishSubject.create()
    val finishOrderSubject: PublishSubject<Order> = PublishSubject.create()

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.binding.click = clickOrderSubject
        holder.binding.preorder = data[position]
        holder.binding.options.setOnClickListener {
            val popup = PopupMenu(context, holder.binding.options)
            //inflating menu from xml resource
            popup.inflate(R.menu.menu_preorder)
            //adding click listener
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.edit -> editOrderSubject.onNext(data[position])
                    R.id.delete -> deleteOrderSubject.onNext(data[position])
                    R.id.finish -> finishOrderSubject.onNext(data[position])
                }
                false
            }
            //displaying the popup
            popup.show()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder
            = OrderHolder(parent.inflate(R.layout.template_order))

    override fun getItemCount(): Int = data.size

    class OrderHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding: TemplateOrderBinding = DataBindingUtil.bind(view)

    }

}