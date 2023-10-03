package com.example.lab3

import android.os.Bundle
import com.google.gson.GsonBuilder
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var okClient: OkHttpClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)


        okClient = OkHttpClient()
        getCountyList(rv)

        rv.layoutManager = LinearLayoutManager(this)



    }

    private fun getCountyList(rv:RecyclerView) {
        val request = Request.Builder()
            .url("https://ru.freeflagicons.com/list/")
            .build()

        okClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.i("AAA", "sht happens")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                runOnUiThread {
                    val countryList = mutableListOf<String>()
                    val res = response.body!!.string()

                    val regex = """<td><a href=\"/country/[a-z]+/\">(.*?)</a></td>""".toRegex()
                    val matcher = regex.findAll(res)

                    for (m in matcher) {
                        countryList.add(m.groupValues[1])
                    }
                    countryList.forEach {
                        Log.i("Z", it)
                    }
                    rv.adapter = RAdapter(countryList, findViewById(R.id.imageView))
                }
            }



        })
    }

}