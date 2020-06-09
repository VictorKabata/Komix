package com.vickikbt.comix.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.vickikbt.comix.R
import com.vickikbt.comix.data.api.ApiService
import com.vickikbt.comix.data.api.RetrofitInstance
import com.vickikbt.comix.data.model.Characters
import com.vickikbt.comix.ui.adapters.RecyclerviewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
    }

    private fun loadData(){
        val retrofitService =
            RetrofitInstance.getRetrofitInstance()
                .create(ApiService::class.java)

        val responseLiveData: LiveData<Response<Characters>> = liveData {
            val response = retrofitService.getCharacters()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val adapter=RecyclerviewAdapter(this, it.body()!!)

            main_recyclerView.adapter=adapter
        })
    }
}