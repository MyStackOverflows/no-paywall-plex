package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serializable
data class EpisodeSerializable(
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
    var media: Array<MediaItem> = arrayOf()
    var directors: Array<String> = arrayOf()
    var roles: Array<String> = arrayOf()
    var writers: Array<String> = arrayOf()
    var addedAt: LocalDateTime = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC)
    var lastViewedAt: LocalDateTime = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC)
    var updatedAt: LocalDateTime = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC)
    var originallyAvailableAt: LocalDateTime = LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC)

    //#region primitives from `episode`
    var grandparentTitle: String = ""
    var grandparentThumb: String = ""
    var parentIndex: Int = -1
    var grandparentSlug: String = ""
    var thumb: String = ""
    var year: Int = -1
    var parentRatingKey: Int = -1
    var grandparentKey: String = ""
    var ratingKey: Int = -1
    var title: String = ""
    var type: String = ""
    var duration: Int = -1
    var grandparentRatingKey: String = ""
    var viewCount: Int = -1
    var skipCount: Int = -1
    var key: String = ""
    var grandparentGuid: String = ""
    var summary: String = ""
    var art: String = ""
    var audienceRating: Float = -1f
    var index: Int = -1
    var parentTitle: String = ""
    var parentThumb: String = ""
    var grandparentTheme: String = ""
    var grandparentArt: String = ""
    var parentKey: String = ""
    var originalTitle: String = ""
    var parentGuid: String = ""
    var guid: String = ""
    var contentRating: String = ""
    var audienceRatingImage: String = ""
    //#endregion

    init {
        val decoder = Json { ignoreUnknownKeys = true }
        val primitives = decoder.decodeFromString<EpisodeSerializable>(json.toString())
        //#region primitive setting
        grandparentTitle = primitives.grandparentTitle
        grandparentThumb = primitives.grandparentThumb
        parentIndex = primitives.parentIndex
        grandparentSlug = primitives.grandparentSlug
        thumb = primitives.thumb
        year = primitives.year
        parentRatingKey = primitives.parentRatingKey
        grandparentKey = primitives.grandparentKey
        ratingKey = primitives.ratingKey
        title = primitives.title
        type = primitives.type
        duration = primitives.duration
        grandparentRatingKey = primitives.grandparentRatingKey
        viewCount = primitives.viewCount
        skipCount = primitives.skipCount
        key = primitives.key
        grandparentGuid = primitives.grandparentGuid
        summary = primitives.summary
        art = primitives.art
        audienceRating = primitives.audienceRating
        index = primitives.index
        parentTitle = primitives.parentTitle
        parentThumb = primitives.parentThumb
        grandparentTheme = primitives.grandparentTheme
        grandparentArt = primitives.grandparentArt
        parentKey = primitives.parentKey
        originalTitle = primitives.originalTitle
        parentGuid = primitives.parentGuid
        guid = primitives.guid
        contentRating = primitives.contentRating
        audienceRatingImage = primitives.audienceRatingImage
        //#endregion

        addedAt = LocalDateTime.ofEpochSecond(primitives.addedAt.toLong(), 0, ZoneOffset.UTC)
        lastViewedAt =
            LocalDateTime.ofEpochSecond(primitives.lastViewedAt.toLong(), 0, ZoneOffset.UTC)
        updatedAt = LocalDateTime.ofEpochSecond(primitives.updatedAt.toLong(), 0, ZoneOffset.UTC)
        // TODO: add originallyAvailableAt here

        directors = Util.getStringArray(json, "Director")
        roles = Util.getStringArray(json, "Role")
        writers = Util.getStringArray(json, "Writer")

        val mediaArray = json.getJSONArray("Media")
        for (i in 0..<mediaArray.length()) {
            media[i] = MediaItem(mediaArray.get(i) as JSONObject)
        }
    }
}