package com.example.richgabrielli.mynews


import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.richgabrielli.mynews.R.id.imageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_list_item.view.*

class NewsAdapter (val articles: Array<Article>, val clickListener: (Article) -> Unit) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.article_list_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolder).bind(articles[position], clickListener)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(art: Article, clickListener: (Article) -> Unit) {
            itemView.title.text = art.title

            var artDesc = ""
            art.description?.let {
                artDesc = art.description
            }
            itemView.description.text = artDesc

            if (art.urlToImage != null) {
                Picasso.get().load(art.urlToImage).into(itemView.imageView)
            } else {
                Picasso.get().load(R.drawable.ic_launcher_background).into(itemView.imageView)
            }


            itemView.setOnClickListener { clickListener(art) }
        }
    }
}