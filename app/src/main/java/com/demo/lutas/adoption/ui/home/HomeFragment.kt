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
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
//    private val navController = findNavController()
    private val animalAdapter by lazy {
        val navController = findNavController()
        AnimalAdapter(navController)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)
        observeData(view)
        return view
    }

    private fun initView(view: View) {
        view.recycler.apply {
            adapter = animalAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAnimals()
    }

    private fun observeData(view: View) {
        observeNonNull(viewModel.animalsState) {
            when (it) {
                is AnimalsState.Loading -> {
                    view.progress_loading.visibility = View.VISIBLE
                }
                is AnimalsState.Succeed -> {
                    view.progress_loading.visibility = View.GONE
                    animalAdapter.updateData(it.animals)
                }
                is AnimalsState.Error -> {
                    view.progress_loading.visibility = View.GONE
                    // TODO
                }
            }
        }
    }
}
