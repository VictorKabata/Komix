package com.vickikbt.comix.util

class EnviromentVariables {
    
    companion object {
        //Request:
        //http://gateway.marvel.com/v1/public/characters?ts=1&apikey=3c7bb3089f0dda1cd39ce38b8c751566&hash=5e5029686a565b82107f981de1fdd98e

        val BASE_URL = "https://gateway.marvel.com/"
        const val ts="1" //Timestamp
        const val publicKey = "3c7bb3089f0dda1cd39ce38b8c751566"
        const val hash = "5e5029686a565b82107f981de1fdd98e" //md5(ts+private_key+public_key)
    }
}