package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

@Serializable
data class ShowPrimitives(
    val studio: String = "",
    val addedAt: Int = -1,
    val thumb: String = "",
    val year: Int = -1,
    val ratingKey: Int = -1,
    val title: String = "",
    val type: String = "",
    val viewedLeafCount: Int = -1,
    val lastViewedAt: Int = -1,
    val duration: Int = -1,
    val theme: String = "",
    val viewCount: Int = -1,
    val key: String = "",
    val updatedAt: Int = -1,
    val summary: String = "",
    val art: String = "",
    val audienceRating: Float = -1f,
    val index: Int = -1,
    val originallyAvailableAt: String = "",
    val childCount: Int = -1,
    val leafCount: Int = -1,
    val originalTitle: String = "",
    val guid: String = "",
    val contentRating: String = "",
    val audienceRatingImage: String = ""
)

class Show(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<ShowPrimitives>(json.toString())
    val roles = Util.getStringArray(json, "Role")
    val genres = Util.getStringArray(json, "Genre")
    val countries = Util.getStringArray(json, "Country")
    val addedAt = LocalDateTime.ofEpochSecond(primitives.addedAt.toLong(), 0, ZoneOffset.UTC)
    val lastViewedAt =
        LocalDateTime.ofEpochSecond(primitives.lastViewedAt.toLong(), 0, ZoneOffset.UTC)
    val updatedAt = LocalDateTime.ofEpochSecond(primitives.updatedAt.toLong(), 0, ZoneOffset.UTC)
    val originallyAvailableAt = LocalDateTime.of(
        LocalDate.parse(this.primitives.originallyAvailableAt), LocalTime.of(0, 0, 0)
    )

    init {
        // todo: add season preloading
    }
}
