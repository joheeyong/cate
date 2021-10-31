package yong.aop.aop.ggookcat.cat


import com.google.gson.annotations.SerializedName

data class Domeggook(
    @SerializedName("items")
    val items: Items? = Items()
)