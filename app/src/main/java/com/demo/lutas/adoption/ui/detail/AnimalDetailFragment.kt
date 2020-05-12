package com.demo.lutas.adoption.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.demo.lutas.adoption.R
import kotlinx.android.synthetic.main.fragment_animal_detail.*


class AnimalDetailFragment : Fragment() {

    private val args: AnimalDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val animal = args.animal
        initImageView(animal.album_file)
        text_gender.text = animal.animal_sex
        text_body_type.text = animal.animal_bodytype
        text_color.text = animal.animal_colour
        text_update_time.text = animal.animal_update
        text_shelter_name.text = animal.shelter_name
        text_shelter_address.text = animal.shelter_address
        text_shelter_tel.text = animal.shelter_tel
    }

    private fun initImageView(photoUrl: String) {
        if (photoUrl.isEmpty()) {
            Glide.with(image_photo)
                .clear(image_photo)
            return
        }
        Glide.with(image_photo)
            .load(photoUrl)
            .centerCrop()
            .into(image_photo)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val navController = findNavController()
                navController.popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
