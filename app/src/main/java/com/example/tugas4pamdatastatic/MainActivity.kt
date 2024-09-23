package com.example.tugas4pamdatastatic

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:ItemAdapter
    private val itemList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            showAddItemDialog()
        }
    }

    private fun showAddItemDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_item, null)
        val namaEdit: EditText = dialogView.findViewById(R.id.namaEdit)
        val deskripsiNama: EditText = dialogView.findViewById(R.id.deskripsiNama)

        AlertDialog.Builder(this)
            .setTitle("Tambah Item Baru")
            .setView(dialogView)
            .setPositiveButton("Tambah") { _, _ ->
                val nama = namaEdit.text.toString()
                val deskripsi = deskripsiNama.text.toString()
                if (nama.isNotEmpty() && deskripsi.isNotEmpty()) {
                    itemList.add(Item(nama, deskripsi))
                    adapter.notifyItemInserted(itemList.size - 1)
                }
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}