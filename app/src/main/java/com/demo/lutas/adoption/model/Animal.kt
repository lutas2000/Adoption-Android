package com.demo.lutas.adoption.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(
    val album_file: String,
    val album_update: String,
    val animal_age: String,
    val animal_area_pkid: Int,
    val animal_bacterin: String,
    val animal_bodytype: String,
    val animal_caption: String,
    val animal_closeddate: String,
    val animal_colour: String,
    val animal_createtime: String,
    val animal_foundplace: String,
    val animal_id: Int,
    val animal_kind: String,
    val animal_opendate: String,
    val animal_place: String,
    val animal_remark: String,
    val animal_sex: String,
    val animal_shelter_pkid: Int,
    val animal_status: String,
    val animal_sterilization: String,
    val animal_subid: String,
    val animal_title: String,
    val animal_update: String,
    val cDate: String,
    val shelter_address: String,
    val shelter_name: String,
    val shelter_tel: String
) : Parcelable