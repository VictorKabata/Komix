package com.vickikbt.comix.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.vickikbt.comix.R
import com.vickikbt.comix.data.api.CharacterService
import com.vickikbt.comix.data.api.RetrofitInstance
import com.vickikbt.comix.data.model.Characters
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService =
            RetrofitInstance.getRetrofitInstance()
                .create(CharacterService::class.java)

        val responseLiveData: LiveData<Response<Characters>> = liveData {
            val response = retrofitService.getCharacters()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val characterList = it.body()?.listIterator()
            if (characterList != null) {
                while (characterList.hasNext()) {
                    val charactersList = characterList.next()
                    val result = " " + "Name: ${charactersList.name}" + "\n" +
                            " " + "Biography: ${charactersList.biography.fullName}" + "\n" +
                            " " + "Appearance: ${charactersList.appearance.gender}" + "\n" +
                            " " + "Powerstats: ${charactersList.powerstats.intelligence}" + "\n" +
                            " \n"

                    textView_main.append(result)
                }
            }
        })
    }
}