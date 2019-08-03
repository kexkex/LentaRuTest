package ru.tomindapps.lentarutest.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.tomindapps.lentarutest.R
import ru.tomindapps.lentarutest.adapters.NewsAdapter
import ru.tomindapps.lentarutest.view_models.NewsActivityViewModel

class NewsActivity : AppCompatActivity() {

    lateinit var newsActivityViewModel: NewsActivityViewModel
    lateinit var rView: RecyclerView
    lateinit var newsAdapter: NewsAdapter
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val mLayoutManager = LinearLayoutManager(this)

        newsAdapter = NewsAdapter()

        newsActivityViewModel = ViewModelProviders.of(this).get(NewsActivityViewModel::class.java)
        newsActivityViewModel.news.observe(this, Observer { n -> n.let { newsAdapter.setupNewsList(it) } })
        newsActivityViewModel.loadNews()

        rView = findViewById(R.id.rv_news)
        rView.apply {
            layoutManager = mLayoutManager
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = true
            adapter = newsAdapter
        }

        fab = findViewById(R.id.floatingActionButton)
        fab.setOnClickListener { newsActivityViewModel.loadNews() }
    }
}
