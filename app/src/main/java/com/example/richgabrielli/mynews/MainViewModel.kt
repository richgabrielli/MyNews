package com.example.richgabrielli.mynews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL


class MainViewModel : ViewModel() {
    private val _data = MutableLiveData<Array<Article>>()


    val data: LiveData<Array<Article>>
        get() = _data

    init {


        GlobalScope.launch {

            val apiKey: String = BuildConfig.ApiKey
            val result = URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=$apiKey").readText()

            val moshi = Moshi.Builder().build()


            val xx = moshi.adapter(News::class.java)
            var products: News? = null
            //var xarticles: Array<Article> = null

            try {
                products = xx.fromJson(result)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            val xy = products!!.articles

//            for (p in xy) {
//                Log.i("NEWS", p.title + " | By: " + p.author + " | Description: " + p.description)
//                //myList.add("ID: " + p.productid + "\n" + "In stock: " + p.instock + "\n" + "Price: " + p.price + "\n" + "Color: " + p.color + "\n" + "Product name: " + p.productname + "\n" + "Offer: " + p.offer + "\n")
//            }

            _data.postValue(xy)
        }

    }

}

