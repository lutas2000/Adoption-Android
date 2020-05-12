package com.demo.lutas.adoption.ui.filter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.geolo.library.taggroup.GeoloTagGroup
import com.demo.lutas.adoption.MainViewModel
import com.demo.lutas.adoption.R
import com.demo.lutas.adoption.repository.AdoptionRepository
import kotlinx.android.synthetic.main.fragment_animal_filter.*
import org.koin.android.viewmodel.ext.android.sharedViewModel


class AnimalFilterFragment : Fragment() {

    private val navController by lazy {
        findNavController()
    }
    private val mainViewModel by sharedViewModel<MainViewModel>()
    private val filterMaps = FilterMaps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        tag_group_kind.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_kind.setTags(filterMaps.kindKeys)
        tag_group_sex.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_sex.setTags(filterMaps.sexKeys)
        tag_group_sterilization.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_sterilization.setTags(filterMaps.sterilizationKeys)
        tag_group_age.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_age.setTags(filterMaps.ageKeys)
        tag_group_body_type.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_body_type.setTags(filterMaps.bodyTypeKeys)
        tag_group_area.switchStyleModel(GeoloTagGroup.STYLE_MODLE_RADIO)
        tag_group_area.setTags(filterMaps.areaKeys)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                navController.popBackStack()
                true
            }
            R.id.menu_filter_done -> {
                mainViewModel.animalFilter = createFilter()
                navController.popBackStack()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createFilter(): AdoptionRepository.Filter {
        return AdoptionRepository.Filter(
            kind = mapTag(tag_group_kind, filterMaps.kindMap),
            sex = mapTag(tag_group_sex, filterMaps.sexMap),
            sterilization = mapTag(tag_group_sterilization, filterMaps.sterilizationMap),
            age = mapTag(tag_group_age, filterMaps.ageMap),
            bodyType = mapTag(tag_group_body_type, filterMaps.bodyTypeMap),
            areaId = mapTag(tag_group_area, filterMaps.areaMap)
        )
    }

    private fun<T> mapTag(tagGroup: GeoloTagGroup, map: Map<String, T>): T? {
        val key = tagGroup.checkedTagList.firstOrNull()
        return map[key]
    }
}