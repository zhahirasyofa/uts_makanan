package com.zhahira.uts_makanan.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhahira.uts_makanan.DetailMakananActivity
import com.zhahira.uts_makanan.R
import com.zhahira.uts_makanan.model.modelmakanan

class adaptermakanan (
    val itemListMakanan: List<modelmakanan>
): RecyclerView.Adapter<adaptermakanan.MyviewHolder>() {
    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtNamaMakanan : TextView = itemView.findViewById(R.id.txtNamaMakanan)
        var imgMakanan : ImageView = itemView.findViewById(R.id.imgMakanan)
        var txtTanggal : TextView = itemView.findViewById(R.id.txtTanggal)
        var txtHarga : TextView = itemView.findViewById(R.id.txtHarga)
        var txtItem : TextView = itemView.findViewById(R.id.txtJumlahItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemListMakanan.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemListMakanan[position]
        holder.txtNamaMakanan.setText(currentItem.Nama)
        holder.imgMakanan.setImageResource(currentItem.image)
        holder.txtTanggal.setText(currentItem.Tanggal)
        holder.txtItem.setText(currentItem.Item)


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailMakananActivity::class.java).apply {
                // Mengirim data melalui intent
                putExtra("namaMakanan", currentItem.Nama)
                putExtra("photoMakanan", currentItem.image)
            }
            context.startActivity(intent)
        }
    }
}
