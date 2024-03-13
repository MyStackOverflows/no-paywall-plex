package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serializable
data class SeasonPrimitives(
    val addedAt: Int = -1,
    val parentIndex: Int = -1,
    val parentStudio: String = "",
    val thumb: String = "",
    val parentRatingKey: Int = -1,
    val ratingKey: Int = -1,
    val title: String = "",
    val type: String = "",
    val viewedLeafCount: Int = -1,
    val lastViewedAt: Int = -1,
    val viewCount: Int = -1,
    val parentTheme: String = "",
    val key: String = "",
    val parentSlug: String = "",
    val updatedAt: Int = -1,
    val summary: String = "",
    val art: String = "",
    val index: Int = -1,
    val parentYear: Int = -1,
    val parentTitle: String = "",
    val parentThumb: String = "",
    val parentKey: String = "",
    val leafCount: Int = -1,
    val parentGuid: String = "",
    val guid: String = ""
)

class Season(private val json: JSONObject) {
    var primitives = Util.decoder.decodeFromString<SeasonPrimitives>(json.toString())
    val addedAt = LocalDateTime.ofEpochSecond(primitives.addedAt.toLong(), 0, ZoneOffset.UTC)
    val lastViewedAt =
        LocalDateTime.ofEpochSecond(primitives.lastViewedAt.toLong(), 0, ZoneOffset.UTC)
    val updatedAt = LocalDateTime.ofEpochSecond(primitives.updatedAt.toLong(), 0, ZoneOffset.UTC)

    init {
        // todo: add episode preloading here
    }
}
