package solutionsyn.mobile.terranovatest.util

import android.databinding.BindingAdapter
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jlbel on 25/09/2017.
 */
private val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

@BindingAdapter("app:dateFormat")
fun applyFormat(textView: TextView, date: Date){
    textView.text = format.format(date)
}

