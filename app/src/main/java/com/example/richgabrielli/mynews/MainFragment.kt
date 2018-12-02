package com.example.richgabrielli.mynews

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.data.observe(this, Observer { data ->
            // Set the text exposed by the LiveData
//            val xx = data!![0].title
//            view?.findViewById<TextView>(R.id.news)?.text = xx

            val myadapter = NewsAdapter(data!!, { partItem : Article -> partItemClicked(partItem) })
            //my_articles.layoutManager = LinearLayoutManager(parent)
            my_articles.hasFixedSize()
            my_articles.adapter = myadapter
            my_articles.setLayoutManager(LinearLayoutManager(context))

        })
    }

    private fun partItemClicked(partItem : Article) {
        Log.i("NEWS", "Clicked: ${partItem.title}")

        // Launch second activity, pass part ID as string parameter
//        val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
//        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
//        startActivity(showDetailActivityIntent)
    }


}
