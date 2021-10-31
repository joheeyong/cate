package yong.aop.aop.ggookcat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import yong.aop.aop.ggookcat.cat.itemlist
import java.util.ArrayList


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    var dataList = ArrayList<itemlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, position: Int) {
        itemViewHolder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
        itemViewHolder.onBind(dataList[position])
    }
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener : OnItemClickListener
    override fun getItemCount(): Int {
        return dataList.size
    }

    fun addItem(item: itemlist) {
        dataList.add(item)
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView1: TextView
        private val textView2: TextView
        private val recyclerView2: RecyclerView
        fun onBind(item: itemlist) {
            textView1.setText(item.id)
//            textView2.setText(yong.aop.aop.retrofitjsonkotlin.Item.body)

            textView1.setOnClickListener {

            }
        }

        init {
            recyclerView2 = itemView.findViewById(R.id.recyclerView1)
            textView1 = itemView.findViewById(R.id.textView1)
            textView2 = itemView.findViewById(R.id.textView2)
        }
    }
}