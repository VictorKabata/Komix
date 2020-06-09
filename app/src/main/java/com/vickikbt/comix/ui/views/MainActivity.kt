package com.vickikbt.comix.ui.views

import RecyclerViewAdapter
import android.os.Bundle
import android.widget.Toast
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
            val characters = arrayListOf<Characters>()

            for (i in 0..characters.size) {
                characters.add(it.body()!!)
                val adapter = RecyclerViewAdapter(this, characters)
                adapter.notifyDataSetChanged()
                main_recyclerView.adapter = adapter

                Toast.makeText(applicationContext, characters.size.toString(), Toast.LENGTH_LONG)
                    .show()
            }


        })
    }
}