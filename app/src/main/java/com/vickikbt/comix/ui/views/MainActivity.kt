package com.vickikbt.comix.ui.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vickikbt.comix.R
import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.viewmodel.MainViewModel

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

            for (i in it.body()!!.data.results.indices) {
                 //Log.e("VickiKbt", i.toString())
                //Log.e("VickiKbt", it.body().toString())
                characters.add(i, it.body()!!)
                Log.e("VickiKbt", characters.toString())
            }

        })
    }


}