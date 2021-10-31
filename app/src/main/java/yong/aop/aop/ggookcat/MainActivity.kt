package yong.aop.aop.ggookcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import yong.aop.aop.ggookcat.cat.itemlist
import yong.aop.aop.ggookcat.cat.cat

class MainActivity : AppCompatActivity() {
    private var adapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView1 = findViewById<View>(R.id.recyclerView1) as RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView1.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter()
        recyclerView1.adapter = adapter

        adapter!!.setItemClickListener (object: RecyclerAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                if(findViewById<TextView>(R.id.good).isVisible){
                    findViewById<TextView>(R.id.good).visibility=View.GONE
                } else{
                    findViewById<TextView>(R.id.good).visibility=View.VISIBLE
                }
            }
        })

        val retrofit = Retrofit.Builder()
            .baseUrl("https://domeggook.com/ssl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
        retrofitAPI.getData().enqueue(object : Callback<cat> {
            override fun onResponse(call: Call<cat>, response: Response<cat>) {
                if (response.isSuccessful) {
                                        Log.d("TEST", response.body()!!.domeggook!!.items!!.item!!.a1!!)
                    for(i in 0 until 5 step 1){
                        val item = itemlist()
//                        item.id==response.body().toString()
                        adapter!!.addItem(item)
                        adapter!!.notifyDataSetChanged()
                    }

                }
            }

            override fun onFailure(call: Call<cat>, t: Throwable) {
                t.printStackTrace()
                Log.d("TEST", "실패")
            }
        })

//
//        itemList.add(ListItem("Ada", "010-1234-5678"))
//        itemList.add(ListItem("James", "010-1234-5678"))
//        itemList.add(ListItem("John", "010-1234-5678"))
//        itemList.add(ListItem("Cena", "010-1234-5678"))
//        listAdapter.notifyDataSetChanged()
    }

    }

