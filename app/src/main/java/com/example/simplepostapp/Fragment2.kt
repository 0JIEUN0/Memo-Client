package com.example.simplepostapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment2 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater.inflate(R.layout.fragment2, container, false)

        var recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        var adapter = MemoAdapter(context)

        // Add Test Data
        adapter.addItem(Memo("user1", "재밌다"))
        adapter.addItem(Memo("user1", "새로운 시도"))
        adapter.addItem(Memo("user2", "이게 뭐야"))
        adapter.addItem(Memo("user810", "재밌다"))
        adapter.addItem(Memo("user1", "새로운 시도"))
        adapter.addItem(Memo("user1103", "이게 뭐야"))
        adapter.addItem(Memo("user12343", "재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 재밌냐? 재밌다 "))
        adapter.addItem(Memo("user1122", "새로운 시도"))
        adapter.addItem(Memo("user748", "이게 뭐야"))
        Log.d("fragment1", "size = ${adapter.items.size}")
        adapter.listener = object : MemoAdapter.OnItemClickListener {
            override fun onItemClick(holder: MemoAdapter.ViewHolder, view: View, position: Int) {
                Toast.makeText(context, "$position 번째 메모 선택함", Toast.LENGTH_SHORT).show()
            }
        }
        recyclerView.adapter = adapter
        return rootView
    }
}