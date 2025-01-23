package com.event.anime.extension

import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType

fun NavArgumentBuilder.nullableArgumentType(navType: NavType<*>) {
    type = navType // Set the type of the argument
    defaultValue = null // Set the default value to null
    nullable = true // Mark the argument as nullable
}