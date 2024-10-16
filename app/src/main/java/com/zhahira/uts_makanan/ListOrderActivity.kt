package com.zhahira.uts_makanan

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhahira.uts_makanan.adapter.adaptermakanan
import com.zhahira.uts_makanan.model.modelmakanan

class ListOrderActivity : AppCompatActivity() {

    private lateinit var RecyclerViewMakanan : RecyclerView
    private lateinit var adaptermakanan: adaptermakanan

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_order)

        val menuMakanan = listOf(
            modelmakanan(R.drawable.food1,"Chicken Curry","29 nov, 01.09 pm","$50.00","2 Items"),
            modelmakanan(R.drawable.food2,"Bean Taco","10 nov, 06.05 pm","$50.00","2 Items"),
            modelmakanan(R.drawable.food3,"Taco Beats","29 nov, 01.09 pm","$50.00","2 Items"),
            modelmakanan(R.drawable.food4,"ayam Betutu","30 nov, 08.45 pm","$50.00","2 Items"),
            modelmakanan(R.drawable.food5,"Nasi Padang","28 nov, 07.00 pm","$50.00","2 Items")

        )

        //inisialisasi recyclerview dan adapter
        RecyclerViewMakanan = findViewById(R.id.RvMakanan)
        RecyclerViewMakanan.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adaptermakanan = adaptermakanan(menuMakanan)
        RecyclerViewMakanan.adapter = adaptermakanan

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}