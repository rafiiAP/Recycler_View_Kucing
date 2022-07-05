package com.example.recyclerviewkucing

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListKucingAdapter(private val listKucing: ArrayList<Kucing>): RecyclerView.Adapter<ListKucingAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_kucing, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val pahlawan = listKucing[position]

        Glide.with(holder.itemView.context)
            .load(pahlawan.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvNama.text = pahlawan.nama
        holder.tvDetail.text = pahlawan.detail

        val mContext = holder.itemView.context
        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_NAME, pahlawan.nama)
            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO, pahlawan.photo)
            moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, pahlawan.detail)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listKucing.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama : TextView = itemView.findViewById(R.id.tv_nama_item)
        var tvDetail : TextView = itemView.findViewById(R.id.tv_detail_item)
        var  imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}