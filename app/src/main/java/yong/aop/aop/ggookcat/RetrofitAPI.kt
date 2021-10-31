package yong.aop.aop.ggookcat

import retrofit2.Call
import retrofit2.http.GET
import yong.aop.aop.ggookcat.cat.cat

interface RetrofitAPI {
    @GET("?ver=2.0&mode=getCat&aid=129f27444e69c7d4d582d254e4a7444f&market=dome&om=json")
    fun getData(): Call<cat>



}