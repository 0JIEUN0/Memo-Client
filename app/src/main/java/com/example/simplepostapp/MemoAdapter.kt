package com.example.simplepostapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class MemoAdapter(val context: Context?) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    var items : MutableList<Memo> = mutableListOf()
    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(holder: ViewHolder, view : View, position: Int)
    }

    fun addItem(memo: Memo) = items.add(memo)
    fun addItems(memos : MutableList<Memo>) {
        items = memos
    }
    fun getItem(position: Int) : Memo = items.get(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater : LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var itemView = inflater.inflate(R.layout.memo, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items.get(position))
        holder.listener = this.listener
    }

    class ViewHolder: RecyclerView.ViewHolder {
        lateinit var listener: OnItemClickListener

        var userName : TextView
        var content : TextView

        constructor(@NonNull itemView: View) : super (itemView){
            this.userName = itemView.findViewById(R.id.userName)
            this.content = itemView.findViewById(R.id.userContent)
            //add ActionListener
            itemView.setOnClickListener { v ->
                val position = adapterPosition
                listener.onItemClick(this@ViewHolder, v, position)
            }
        }

        fun setItem(memo : Memo) {
            this.userName.text = memo.userName
            this.content.text = memo.content
        }


    }


}