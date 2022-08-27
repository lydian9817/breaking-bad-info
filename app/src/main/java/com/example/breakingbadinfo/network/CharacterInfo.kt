package com.example.breakingbadinfo.network

import com.squareup.moshi.Json

data class CharacterInfo(
    @Json(name = "char_id") val id: Int,
    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: List<Int>,
    val portrayed: String,
    val category: String,
    @Json(name = "better_call_saul_appearance") val bcsAppearance: List<Int>
)
