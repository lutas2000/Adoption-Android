package com.demo.lutas.adoption.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.lutas.adoption.R
import com.demo.lutas.adoption.observeNonNull
import com.demo.lutas.adoption.ui.EndlessScrollListener
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private val animalAdapter by lazy {
        val navController = findNavController()
        AnimalAdapter(navController)
    }
    private var scrollListener: EndlessScrollListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
        viewModel.fetchAnimals()
    }

    private fun initView() {
        swipe_layout.setOnRefreshListener {
            viewModel.fetchAnimals()
        }
        recycler.apply {
            adapter = animalAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            scrollListener = EndlessScrollListener(linearLayoutManager) {
                viewModel.fetchMoreAnimals()
            }
            addOnScrollListener(scrollListener!!)
        }
    }

    private fun observeData() {
        observeNonNull(viewModel.animalsState) {
            when (it) {
                is AnimalsState.Loading -> {
                    progress_loading.visibility = View.VISIBLE
                }
                is AnimalsState.Reloading -> {
                    swipe_layout.isRefreshing = true
                }
                is AnimalsState.Succeed -> {
                    clearLoadingViews()
                    scrollListener?.loadingDone()
                    animalAdapter.updateData(it.animals)
                }
                is AnimalsState.Error -> {
                    clearLoadingViews()
                    // TODO
                }
            }
        }
    }

    private fun clearLoadingViews() {
        progress_loading.visibility = View.GONE
        swipe_layout.isRefreshing = false
    }
}
