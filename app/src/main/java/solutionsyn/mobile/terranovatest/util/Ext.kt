package solutionsyn.mobile.terranovatest.util

import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by jlbel on 24/09/2017.
 */
fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()


infix fun CompositeDisposable.push(disposable: Disposable){
    add(disposable)
}
