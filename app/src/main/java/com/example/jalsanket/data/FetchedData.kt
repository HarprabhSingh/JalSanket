package com.example.jalsanket.data

data class FetchedData(
    val title: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val result: Int?,
    val time: String?
)
