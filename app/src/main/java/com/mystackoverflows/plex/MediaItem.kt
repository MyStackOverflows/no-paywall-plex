package com.mystackoverflows.plex

import org.json.JSONObject

data class MediaItemSerializable(
    val container: String = "",
    val videoProfile: String = "",
    val aspectRatio: Float = -1f,
    val bitrate: Int = -1,
    val audioCodec: String = "",
    val videoFrameRate: String = "",
    val duration: Int = -1,
    val audioChannels: Int = -1,
    val audioProfile: String = "",
    val width: Int = -1,
    val id: Int = -1,
    val videoResolution: String = "",
    val height: Int = -1,
    val videoCodec: String = "",
)

class MediaItem(private val json: JSONObject) {
    init {

    }
}