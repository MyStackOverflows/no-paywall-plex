package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

@Serializable
data class MoviePrimitives(
    val studio: String = "",
    val addedAt: Int = -1,
    val thumb: String = "",
    val year: Int = -1,
    val ratingKey: Int = -1,
    val title: String = "",
    val type: String = "",
    val lastViewedAt: Int = -1,
    val duration: Int = -1,
    val viewCount: Int = -1,
    val skipCount: Int = -1,
    val key: String = "",
    val updatedAt: Int = -1,
    val summary: String = "",
    val art: String = "", 
    val audienceRating: Float = -1f,
    val originallyAvailableAt: String = "",
    val originalTitle: String = "",
    val guid: String = "",
    val tagline: String = "",
    val contentRating: String = "",
    val audienceRatingImage: String = ""
)

class Movie(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<MoviePrimitives>(json.toString())
    var media: Array<MediaItem?> = arrayOf()
    val directors = Util.getStringArray(json, "Director")
    val roles = Util.getStringArray(json, "Role")
    val writers = Util.getStringArray(json, "Writer")
    val addedAt = LocalDateTime.ofEpochSecond(primitives.addedAt.toLong(), 0, ZoneOffset.UTC)
    val lastViewedAt =
        LocalDateTime.ofEpochSecond(primitives.lastViewedAt.toLong(), 0, ZoneOffset.UTC)
    val updatedAt = LocalDateTime.ofEpochSecond(primitives.updatedAt.toLong(), 0, ZoneOffset.UTC)
    val originallyAvailableAt = LocalDateTime.of(
        LocalDate.parse(this.primitives.originallyAvailableAt), LocalTime.of(0, 0, 0)
    )

    init {
        val mediaArray = json.getJSONArray("Media")
        media = arrayOfNulls<MediaItem>(mediaArray.length())
        for (i in 0..<mediaArray.length())
            media[i] = MediaItem(mediaArray.get(i) as JSONObject)
    }
}
