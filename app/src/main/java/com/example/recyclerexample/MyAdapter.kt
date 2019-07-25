package com.example.recyclerexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MyAdapter(val listItem: List<MyEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    OnTitleSelected {

    var showingListItem: ArrayList<MyEntity> = arrayListOf()

    init {
        showingListItem = ArrayList(listItem.filter { it.title })
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            0, 1 -> RecyclerItem(LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_item, viewGroup, false))
            2 -> RecyclerTitle(LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_title, viewGroup, false))
            else -> RecyclerEmpty(LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_empty, viewGroup, false))
        }
    }

    override fun getItemCount(): Int {
        return showingListItem.size
    }

    override fun getItemViewType(position: Int): Int {
        if (showingListItem[position].title) return 2
        else return showingListItem[position].nationality.ordinal
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)){
            0 -> (viewHolder as RecyclerItem).bindBrazilianPresident(showingListItem[position])
            1 -> (viewHolder as RecyclerItem).bindAmericanPresident(showingListItem[position])
            2 -> (viewHolder as RecyclerTitle).bindTitle(showingListItem[position], this)
        }
    }

    override fun titleSelected(nationality: Nationality) {
        val nationalityList = showingListItem.filter { !it.title && it.nationality == nationality }
        if (nationalityList.isEmpty()) {
            //show itens
            val indexOfTitle = showingListItem.indexOf(showingListItem.filter { it.title && it.nationality == nationality }.first())
            val itemsNationality = listItem.filter { !it.title && it.nationality == nationality }
            showingListItem.addAll(indexOfTitle + 1, itemsNationality)
            notifyItemRangeInserted(indexOfTitle + 1, itemsNationality.size)
        } else {
            // remove itens from adapter
            val indexOfFirstItem = showingListItem.indexOf(nationalityList.first())
            showingListItem.removeAll(nationalityList)
            notifyItemRangeRemoved(indexOfFirstItem, nationalityList.size)
        }
    }
}

interface OnTitleSelected {
    fun titleSelected(nationality: Nationality)
}