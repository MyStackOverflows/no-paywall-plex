package com.mystackoverflows.plex

import kotlinx.serialization.Serializable

@Serializable
data class PartItem(
    val container: String = "",
    val duration: Int = -1,
    val audioProfile: String = "",
    val file: String = "",
    val size: Long = -1,
    val videoProfile: String = "",
    val id: Int = -1,
    val key: String = ""
)