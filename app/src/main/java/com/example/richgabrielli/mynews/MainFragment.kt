package com.example.richgabrielli.mynews

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

            val myadapter = NewsAdapter(data!!, { partItem : Article -> articleClicked(partItem) })
            my_articles.hasFixedSize()
            my_articles.adapter = myadapter
            my_articles.setLayoutManager(LinearLayoutManager(context))

        })
    }

    private fun articleClicked(partItem : Article) {
        Log.i("NEWS", "Clicked: ${partItem.title}")

        // Launch second activity, pass part ID as string parameter
//        val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
//        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
//        startActivity(showDetailActivityIntent)
    }


}
