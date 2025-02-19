package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.viewModel.MyViewModel
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MyViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.vmss = viewModel
        val adapter = MovieAdapter(listOf(), this)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.btn.setOnClickListener {
            viewModel.displaytext = "Hello, Hello it stays"
        }
        subscribeObservers(binding)
        viewModel.getAllData()
    }

    private fun subscribeObservers(binding: ActivityMainBinding) = with(viewModel) {
        lifecycleScope.launch {
            resultDataList.collect {
                it?.let {
                    (binding.recyclerView.adapter as MovieAdapter).dataList = it
                    refreshRecyclerView()
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun refreshRecyclerView() = with(binding.recyclerView.adapter) {
        this?.notifyDataSetChanged()
    }

}