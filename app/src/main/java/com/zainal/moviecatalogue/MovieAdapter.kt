package com.zainal.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter(){

    internal var movies = arrayListOf<Movie>()

    override fun getCount(): Int = movies.size

    override fun getItem(i: Int): Any = movies[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View){
        private val txtTitle: TextView = view.findViewById(R.id.txt_title)
        private val txtOverview: TextView = view.findViewById(R.id.txt_overview)
        private val imgPoster : ImageView = view.findViewById(R.id.img_poster)

        internal fun bind(movie: Movie) {
            txtTitle.text = movie.title
            txtOverview.text = movie.overview
            Glide.with(context)
                .load(movie.poster)
                .apply(RequestOptions().override(100,150))
                .into(imgPoster)
        }
    }
}