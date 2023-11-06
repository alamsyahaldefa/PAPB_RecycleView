package com.example.papb_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.papb_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ganjar: String
    private lateinit var anies: String
    private lateinit var prabowo: String
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ganjar = getString(R.string.ganjar)
        anies = getString(R.string.anies)
        prabowo = getString(R.string.prabowo)

        fun generateDummy(): List<Pahlawan> {
            return listOf(
                Pahlawan(namaPahlawan = "Ganjar Pranowo", gambarPahlawan = R.drawable.ganjar, deskripsiPahlawan = ganjar),
                Pahlawan(namaPahlawan = "Anies Baswedan", gambarPahlawan = R.drawable.anies, deskripsiPahlawan = anies),
                Pahlawan(namaPahlawan = "Prabowo Subianto", gambarPahlawan = R.drawable.prabowo, deskripsiPahlawan = prabowo),
            )
        }

        val adapterPahlawan = MyAdapter(generateDummy()){
                pahlawan ->  Toast.makeText(this, "${pahlawan.namaPahlawan}",
            Toast.LENGTH_SHORT).show()
        }
        with(binding){
            recycle.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
}