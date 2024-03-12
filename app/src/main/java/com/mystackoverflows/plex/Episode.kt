package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

@Serializable
data class EpisodePrimitives(
    val grandparentTitle: String = "",
    val addedAt: Int = -1,
    val grandparentThumb: String = "",
    val parentIndex: Int = -1,
    val grandparentSlug: String = "",
    val thumb: String = "",
    val year: Int = -1,
    val parentRatingKey: Int = -1,
    val grandparentKey: String = "",
    val ratingKey: Int = -1,
    val title: String = "",
    val type: String = "",
    val lastViewedAt: Int = -1,
    val duration: Int = -1,
    val grandparentRatingKey: String = "",
    val viewCount: Int = -1,
    val skipCount: Int = -1,
    val key: String = "",
    val grandparentGuid: String = "",
    val updatedAt: Int = -1,
    val summary: String = "",
    val art: String = "",
    val audienceRating: Float = -1f,
    val index: Int = -1,
    val originallyAvailableAt: String = "",
    val parentTitle: String = "",
    val parentThumb: String = "",
    val grandparentTheme: String = "",
    val grandparentArt: String = "",
    val parentKey: String = "",
    val originalTitle: String = "",
    val parentGuid: String = "",
    val guid: String = "",
    val contentRating: String = "",
    val audienceRatingImage: String = ""
)

class Episode(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<EpisodePrimitives>(json.toString())
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