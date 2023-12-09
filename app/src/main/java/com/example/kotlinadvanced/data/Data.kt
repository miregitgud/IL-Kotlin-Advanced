package com.example.kotlinadvanced.data

import com.example.kotlinadvanced.R

data class Item(val name: String, val imageResId: Int)

object Data {
    val dataList = listOf(
        Item("Item 1", R.drawable.ic_android),
        Item("Item 2", R.drawable.ic_android),
        Item("Item 3", R.drawable.ic_android),
        Item("Item 4", R.drawable.ic_apple),
        Item("Item 5", R.drawable.ic_apple),
        Item("Item 6", R.drawable.ic_apple),
        Item("Item 7", R.drawable.ic_banana),
        Item("Item 8", R.drawable.ic_banana),
        Item("Item 9", R.drawable.ic_banana),
        Item("Item 10", R.drawable.ic_android),
        Item("Item 11", R.drawable.ic_android),
        Item("Item 12", R.drawable.ic_android),
        Item("Item 13", R.drawable.ic_apple),
        Item("Item 14", R.drawable.ic_apple),
        Item("Item 15", R.drawable.ic_apple),
        Item("Item 16", R.drawable.ic_banana),
        Item("Item 17", R.drawable.ic_banana),
        Item("Item 18", R.drawable.ic_banana),
        Item("Item 19", R.drawable.ic_android),
        Item("Item 20", R.drawable.ic_android),
        Item("Item 21", R.drawable.ic_android),
        Item("Item 22", R.drawable.ic_apple),
        Item("Item 23", R.drawable.ic_apple),
        Item("Item 24", R.drawable.ic_apple),
        Item("Item 25", R.drawable.ic_banana),
        Item("Item 26", R.drawable.ic_banana),
        Item("Item 27", R.drawable.ic_banana)
    )
}