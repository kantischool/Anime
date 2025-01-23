package com.event.anime.navigation

sealed class Screen(val route: String, val name: String) {

    data object AnimeScreen : Screen(route = "anime_screen", name = "AnimeScreen")

    data object AnimeDetailScreen : Screen(route = "anime_detail_screen", name = "AnimeDetailScreen")

    fun withOptionalArgs(hashMap: HashMap<String, Any?>) = buildString {
        append(route.plus("?"))
        hashMap.entries.forEachIndexed { index, entry ->
            if (index == hashMap.size - 1) {
                append("${entry.key}=${entry.value}")
            } else {
                append("${entry.key}=${entry.value}&")
            }
        }
    }

    fun buildOptionalArgsRoute(vararg args: Any) = buildString {
        append(route.plus("?"))
        args.forEachIndexed { index, any ->
            if (index == args.size - 1) {
                append("$any={$any}")
            } else {
                append("$any={$any}&")
            }
        }
    }
}