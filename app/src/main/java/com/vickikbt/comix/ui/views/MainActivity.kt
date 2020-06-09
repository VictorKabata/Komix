package com.vickikbt.comix.ui.views

import RecyclerViewAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.vickikbt.comix.R
import com.vickikbt.comix.data.api.RetrofitInstance.Companion.retrofitService
import com.vickikbt.comix.data.model.Characters
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData() {

        val responseLiveData: LiveData<Response<Characters>> = liveData {
            val response = retrofitService.getCharacters()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val adapter=RecyclerViewAdapter(this)
            main_recyclerView.adapter=adapter

            //textView_main.text = it.body()!!.data.results.size.toString()
        })
    }
}