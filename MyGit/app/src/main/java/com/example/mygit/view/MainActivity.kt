package com.example.mygit.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygit.R
import com.example.mygit.viewmodel.PullRequestViewModel
import kotlinx.android.synthetic.main.activity_main.*






class MainActivity : AppCompatActivity() {

   private lateinit var viewModel: PullRequestViewModel

    private val pullRequestAdapter = PullRequestAdapter(arrayListOf())






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)


        viewModel.refresh()

        recyclerList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pullRequestAdapter
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        observeViewModel()






    }

    fun observeViewModel(){
        viewModel.pullRequestList.observe(this, Observer { pullRequestList->
            pullRequestList?.let {
                recyclerList.visibility = View.VISIBLE
                pullRequestAdapter.updatePullRequestList(it)
            }
        })

        viewModel.pullRequestLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    recyclerList.visibility = View.GONE
                }
            }
        })
    }
}