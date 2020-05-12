package com.demo.lutas.adoption.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class EndlessScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadMode: () -> Unit
) : RecyclerView.OnScrollListener() {

    private var loading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        if (dy > 0) {
            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
            if (loading) {
                if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                    loading = false
                    loadMode()
                }
            }
        }
    }

    fun loadingDone() {
        loading = true
    }
}