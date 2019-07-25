package com.example.recyclerexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mAdapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecycler()
    }

    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(this)

        recycler_view.layoutManager = layoutManager

        mAdapter = MyAdapter(getListItems())
        recycler_view.adapter = mAdapter

        recycler_view.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
    }

    private fun getListItems() : List<MyEntity> {
        return listOf(MyEntity(name = "American Presidents", nationality = Nationality.AMERICAN, title = true),
            MyEntity(name = "Obama", nationality = Nationality.AMERICAN),
            MyEntity(name = "Trump", nationality = Nationality.AMERICAN),
            MyEntity(name = "Brazilian Presidents", nationality = Nationality.BRAZILIAN, title = true),
            MyEntity(name = "Lula", nationality = Nationality.BRAZILIAN),
            MyEntity(name = "Dilma", nationality = Nationality.BRAZILIAN),
            MyEntity(name = "FHC", nationality = Nationality.BRAZILIAN),
            MyEntity(name = "Bolsonaro", nationality = Nationality.BRAZILIAN),
            MyEntity(name = "Temer", nationality = Nationality.BRAZILIAN))
    }
}
