package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serializable
data class PlexServerPrimitives(
    val name: String = "",
    val product: String = "",
    val productVersion: String = "",
    val platform: String = "",
    val platformVersion: String = "",
    val device: String = "",
    val clientIdentifier: String = "",
    val createdAt: Int = -1,
    val lastSeenAt: Int = -1,
    val provides: String = "",
    val ownerId: String = "",
    val sourceTitle: String = "",
    val publicAddress: String = "",
    val accessToken: String = "",
    val owned: Boolean = false,
    val home: Boolean = false,
    val synced: Boolean = false,
    val relay: Boolean = false,
    val presence: Boolean = false,
    val httpsRequired: Boolean = false,
    val publicAddressMatches: Boolean = false,
    val dnsRebindingProtection: Boolean = false,
    val natLoopbackSupported: Boolean = false,
)

class PlexServer(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<PlexServerPrimitives>(json.toString())
    var connections: Array<ServerConnection?> = arrayOf()
    val createdAt = LocalDateTime.ofEpochSecond(primitives.createdAt.toLong(), 0, ZoneOffset.UTC)
    val lastSeenAt = LocalDateTime.ofEpochSecond(primitives.lastSeenAt.toLong(), 0, ZoneOffset.UTC)

    init {
        // TODO: double check serverconnections here is actually functional
        val connectionArray = json.getJSONArray("connections")
        connections = arrayOfNulls<ServerConnection>(connectionArray.length())
        for (i in 0..<connectionArray.length())
            connections[i] = ServerConnection(connectionArray.get(i) as JSONObject)
    }
}
