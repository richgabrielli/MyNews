package com.example.richgabrielli.mynews

import java.io.Serializable

data class News (
    val status: String="",
    val articles: Array<Article>
): Serializable

data class Article (
    val author: String = "",
    val title: String = "",
    val description: String = ""
): Serializable



