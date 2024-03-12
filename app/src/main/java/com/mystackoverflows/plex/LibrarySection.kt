package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serializable
data class LibrarySectionPrimitives(
    val agent: String,
    val art: String,
    val scannedAt: Int,
    val hidden: Boolean,
    val thumb: String,
    val contentChangedAt: Int,
    val allowSync: Boolean,
    val language: String,
    val filters: Boolean,
    val title: String,
    val type: String,
    val directory: Boolean,
    val uuid: String,
    val content: Boolean,
    val createdAt: Int,
    val composite: String,
    val refreshing: Boolean,
    val scanner: String,
    val key: Int,
    val updatedAt: Int
)

class LibrarySection(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<LibrarySectionPrimitives>(json.toString())
    val locations = Util.getStringArray(json, "Location", "path")
    val scannedAt = LocalDateTime.ofEpochSecond(primitives.scannedAt.toLong(), 0, ZoneOffset.UTC)
    val contentChangedAt =
        LocalDateTime.ofEpochSecond(primitives.contentChangedAt.toLong(), 0, ZoneOffset.UTC)
    val createdAt = LocalDateTime.ofEpochSecond(primitives.createdAt.toLong(), 0, ZoneOffset.UTC)
    val updatedAt = LocalDateTime.ofEpochSecond(primitives.updatedAt.toLong(), 0, ZoneOffset.UTC)
    var libraryShows: Array<Show> = arrayOf()
    var libraryMovies: Array<Movie> = arrayOf()
    // todo: add 'preloading' and downloading metadata content

    init {
        if (primitives.type == "show") {
            // load library's show content here
        } else if (primitives.type == "movie") {
            // load library's movie content here
        }
    }
}