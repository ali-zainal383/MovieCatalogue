package com.zainal.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataOverview: Array<String>
    private lateinit var dataPoster: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_movie)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            val detailMovie = Intent(this@MainActivity, DetailMovieActivity::class.java)
            val movie = adapter.movies[position]
            detailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
            startActivity(detailMovie)
        }
    }

    private fun prepare() {
        dataTitle = resources.getStringArray(R.array.data_title)
        dataOverview = resources.getStringArray(R.array.data_overview)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
    }

    private fun addItem() {
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPoster.getResourceId(position, -1),
                dataTitle[position],
                dataOverview[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
