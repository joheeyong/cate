package yong.aop.aop.ggookcat.cat


import com.google.gson.annotations.SerializedName

data class cat(
    @SerializedName("domeggook")
    val domeggook: Domeggook? = Domeggook()
)