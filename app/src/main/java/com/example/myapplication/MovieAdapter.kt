package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemViewBinding

class MovieAdapter(
    var dataList: List<Results>,
    private val context: Context
): RecyclerView.Adapter<MovieAdapter.CustomViewHolder>() {

    class CustomViewHolder(
        private val resultBinding: ItemViewBinding
    ) : RecyclerView.ViewHolder(resultBinding.root) {

        fun bind(resultData: Results) {
            resultBinding.data = resultData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =  DataBindingUtil.inflate<ItemViewBinding>(
            LayoutInflater.from(context),
            R.layout.item_view,
            parent,
            false
        )
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}