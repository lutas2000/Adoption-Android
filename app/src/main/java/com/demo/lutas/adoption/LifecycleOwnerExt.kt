package com.demo.lutas.adoption

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> Fragment.observe(data: LiveData<T>, onChange: (T?) -> Unit) {
    data.observe(this.viewLifecycleOwner, Observer<T?> {
        onChange(it)
    })
}

fun <T> Fragment.observeNonNull(data: LiveData<T>, onChange: (T) -> Unit) {
    data.observe(this.viewLifecycleOwner, Observer<T> {
        if (it != null) {
            onChange(it)
        }
    })
}

//fun <T> LifecycleOwner.observe(data: LiveData<T>, onChange: (T?) -> Unit) {
//    data.observe(this, Observer<T?> {
//        onChange(it)
//    })
//}
//
//fun LifecycleOwner.observeVisible(data: LiveData<Boolean>, view: View) {
//    data.observe(this, Observer<Boolean?> {
//        view.visibility = if (it == true) View.VISIBLE else View.GONE
//    })
//}
//
//fun <T> LifecycleOwner.observeNonNull(data: LiveData<T>, onChange: (T) -> Unit) {
//    data.observe(this, Observer<T> {
//        if (it != null) {
//            onChange(it)
//        }
//    })
//}