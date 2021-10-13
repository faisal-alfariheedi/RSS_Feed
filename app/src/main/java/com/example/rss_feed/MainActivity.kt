package com.example.rss_feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    lateinit var refbut: Button
    lateinit var rv: RecyclerView
    var entr = arrayListOf<xmlpars.Entry>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rvm)
        rv.layoutManager = LinearLayoutManager(this)
        val policy = StrictMode.ThreadPolicy.Builder()
            .permitAll().build()
        StrictMode.setThreadPolicy(policy)



        val parser = xmlpars()
        val url = URL("https://stackoverflow.com/feeds")
        val urlConnection = url.openConnection() as HttpsURLConnection
        entr = urlConnection.getInputStream()?.let { parser.parse(it) } as ArrayList<xmlpars.Entry>


//           entr = parser.parse(inxml)
        rv.adapter = RVAdapter(entr, this)

        Log.d("bordiga", "$entr")
    }
}
