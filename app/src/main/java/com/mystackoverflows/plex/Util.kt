package com.mystackoverflows.plex

import kotlinx.serialization.json.Json
import org.json.JSONArray
import org.json.JSONObject

class Util {
    companion object {
        val decoder = Json { ignoreUnknownKeys = true }
        fun getStringArray(
            json: JSONObject, key: String, innerTag: String = "tag"
        ): Array<String> {
            if (json.has(key)) {
                val arr = json.getJSONArray(key)
                val out = Array(arr.length()) { "" }
                for (i in 0..<arr.length())
                    out[i] = (arr.get(i) as JSONObject).getString(innerTag)
                return out
            }
            return arrayOf();
        }

    }
}