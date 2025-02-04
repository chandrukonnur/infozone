package com.example.infozone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.infozone.db.ArticleDatabase
import com.example.infozone.repository.NewsRepository
import com.example.newsprojectpractice.R
import com.example.newsprojectpractice.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        newsViewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}