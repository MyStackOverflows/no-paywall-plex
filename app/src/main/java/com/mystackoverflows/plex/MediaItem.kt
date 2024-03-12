package com.mystackoverflows.plex

import org.json.JSONObject

data class MediaItemPrimitives(
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
    val primitives = Util.decoder.decodeFromString<MediaItemPrimitives>(json.toString())
    var parts: Array<PartItem?> = arrayOf()

    init {
        val partArray = json.getJSONArray("Part")
        parts = arrayOfNulls<PartItem>(partArray.length())
        for (i in 0..<partArray.length())
            parts[i] = Util.decoder.decodeFromString((partArray[i] as JSONObject).toString())
    }
}