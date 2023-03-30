package com.example.apiretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.apiretrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val Base_Url="https://timeapi.io/api/Time/current/"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun getTime(view: View){

        val retrofit = Retrofit.Builder()
            .baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
       val service = retrofit.create(TimeApi::class.java)
        val call=service.getData()

        call.enqueue(object :Callback<GetApi> {
            override fun onResponse(call: Call<GetApi>, response: Response<GetApi>) {

                if(response.isSuccessful){
                    response.body()?.let {
                        binding.textView.setText(it.time)
                        binding.textView3.setText(it.date)
                    }


                }


            }

            override fun onFailure(call: Call<GetApi>, t: Throwable) {
                t.printStackTrace()

            }

        })


    }




}