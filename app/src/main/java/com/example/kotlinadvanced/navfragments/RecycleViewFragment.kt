package com.example.kotlinadvanced.navfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinadvanced.R
import com.example.kotlinadvanced.data.Data
import com.example.kotlinadvanced.recycleviewfragmentadapter.MyAdapter

class RecycleViewFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recyclerview, container, false)

        // Initialize RecyclerView with a GridLayoutManager for two columns
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        // Initialize and set the adapter
        adapter = MyAdapter(Data.dataList)
        recyclerView.adapter = adapter

        return view
    }
}