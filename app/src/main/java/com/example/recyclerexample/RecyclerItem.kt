package com.example.recyclerexample

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView = itemView.textView
    private val imageView = itemView.imageView
    private val rootView = itemView.rootView

    fun bindBrazilianPresident(entity: MyEntity) {
        textView.text = entity.name
        imageView.setImageResource(R.drawable.ic_launcher_background)
    }

    fun bindAmericanPresident(entity: MyEntity) {
        textView.text = entity.name
        imageView.setImageResource(R.drawable.ic_launcher_foreground)
    }
}