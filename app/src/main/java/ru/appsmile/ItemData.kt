package ru.appsmile

import androidx.annotation.DrawableRes
import java.io.Serializable

data class ItemData(
    @DrawableRes val icon: Int,
    val strana: String
) : Serializable