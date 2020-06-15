package com.vickikbt.comix.ui.views

import RecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vickikbt.comix.R
import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        showData()

    }

    private fun showData() {
        viewModel.myData.observe(this, Observer {

            val characters = arrayListOf<Characters>()

            val results = it.body()!!.data.results
            for (i in results.indices) {
                characters.add(i, it.body()!!)
                val adapter = RecyclerViewAdapter(this, characters)
                main_recyclerView.adapter = adapter
            }

            //Picasso.get().load("https://github.com/square/picasso/raw/master/website/static/sample.png").into(imageView_main)
            //Glide.with(this).load("https://github.com/square/picasso/raw/master/website/static/sample.png").into(imageView_main)

            Log.e("VickiKbt", characters.size.toString())
            Log.e("VickiKbt", results.toString())

        })
    }


}