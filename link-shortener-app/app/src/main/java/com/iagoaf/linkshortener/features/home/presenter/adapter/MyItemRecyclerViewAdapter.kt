package com.iagoaf.linkshortener.features.home.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iagoaf.linkshortener.databinding.LinkFragmentItemBinding
import com.iagoaf.linkshortener.features.home.domain.models.LinkModel

class MyItemRecyclerViewAdapter(
    private var values: List<LinkModel>,
    private val onClickCopy: (LinkModel) -> Unit = {},
    private val onClickDelete: (LinkModel) -> Unit = {},
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LinkFragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link = values[position]
        holder.title.text = link.shortLink
        holder.subtitle.text = link.originalLink
        holder.access.text = link.access.toString()
        holder.btnCopy.setOnClickListener { _ -> onClickCopy(link) }
        holder.btnDelete.setOnClickListener { _ -> onClickDelete(link) }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: LinkFragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.tvTitleShortenedLink
        val subtitle: TextView = binding.tvSubtitleShortenedLink
        val access: TextView = binding.tvAccessCount
        val btnCopy: ImageButton = binding.btnCopyLink
        val btnDelete: ImageButton = binding.btnDeleteLink
    }

    fun setItems(newItems: List<LinkModel>) {
        values = newItems
        notifyDataSetChanged()
    }

}