package com.demo.lutas.adoption.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.lutas.adoption.R
import com.demo.lutas.adoption.model.Animal
import kotlinx.android.synthetic.main.item_animal_list.view.*

class AnimalAdapter(
    private val navController: NavController
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewTypeList = 0
    private val viewTypeGrid = 1
    private val data = mutableListOf<Animal>()

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(animal: Animal) {
            bindPhoto(animal.album_file)
            itemView.apply {
                text_gender.text = animal.animal_sex
                text_body_type.text = animal.animal_bodytype
                text_color.text = animal.animal_colour
                text_shelter_name.text = animal.shelter_name
                text_update_time.text = animal.animal_update
                setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeToAnimalDetail(animal)
                    navController.navigate(action)
                }
            }
        }

        private fun bindPhoto(photoUrl: String) {
            if (photoUrl.isEmpty()) {
                Glide.with(itemView.context)
                    .clear(itemView.image_photo)
                return
            }
            Glide.with(itemView.context)
                .load(photoUrl)
                .centerCrop()
                .into(itemView.image_photo)
        }
    }

    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {

        }
    }

    fun updateData(newData: List<Animal>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypeList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            viewTypeList -> {
                val view = layoutInflater.inflate(R.layout.item_animal_list, parent, false)
                ListViewHolder(view)
            }
            else -> throw IllegalStateException("Unknown viewType: $viewType")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animal = data[position]
        when (holder) {
            is ListViewHolder -> holder.bind(animal)
        }
    }
}