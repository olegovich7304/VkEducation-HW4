package io.mmaltsev.vkeducation.data.applist

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppListItemDto(
    val id: String,
    val name: String,
    val category: String = "",
    val description: String = "",
    @SerialName("iconUrl")
    val icon: String? = null,
)