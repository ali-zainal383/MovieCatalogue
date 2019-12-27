package com.zainal.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val imgPosterDetail: ImageView = findViewById(R.id.img_poster_detail)
        val txtTitleDetail: TextView = findViewById(R.id.txt_title_detail)
        val txtOverviewDetail: TextView = findViewById(R.id.txt_overview_detail)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        val poster = movie.poster
        val title = movie.title
        val overview = movie.overview

        imgPosterDetail.setImageResource(poster)
        txtTitleDetail.text = title
        txtOverviewDetail.text = overview
    }
}
