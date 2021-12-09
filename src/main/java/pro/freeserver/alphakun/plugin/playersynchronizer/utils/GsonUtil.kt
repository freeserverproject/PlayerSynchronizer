package pro.freeserver.alphakun.plugin.playersynchronizer.utils

import com.google.gson.Gson

object GsonUtil {
    fun <T> toJson(obj: T): String {
        return Gson().toJson(obj)
    }

    fun <T> fromJson(json: String, clazz: Class<T>): T {
        return Gson().fromJson(json, clazz)
    }
}