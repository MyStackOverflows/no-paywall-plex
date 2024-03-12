package com.mystackoverflows.plex

import kotlinx.serialization.Serializable
import org.json.JSONObject
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

@Serializable
data class ServerConnectionPrimitives(
    val protocol: String = "",
    val address: String = "",
    val port: Int = -1,
    val uri: String = "",
    val local: Boolean = false,
    val relay: Boolean = false,
    val ipv6: Boolean = false,
)

class ServerConnection(private val json: JSONObject) {
    val primitives = Util.decoder.decodeFromString<ServerConnectionPrimitives>(json.toString())
    var domain = primitives.uri.substring(8)  // cut off 'https://'
    domain = domain.substring(0, domain.indexOf(":")) // remove ':<portnum>'
}
