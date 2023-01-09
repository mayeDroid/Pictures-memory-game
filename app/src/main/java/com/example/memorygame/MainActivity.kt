package com.example.memorygame

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerViewBoard: RecyclerView
private lateinit var tvNoOfMoves: TextView
private lateinit var tvNoOfPairs: TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewBoard = findViewById(R.id.recyclerViewBoard)
        tvNoOfMoves = findViewById(R.id.tvNoOfMoves)
        tvNoOfPairs = findViewById(R.id.tvNoOfPairs)

        recyclerViewBoard.adapter = PicturesAdapter(this, 8)         // the total number of pieces
        recyclerViewBoard.layoutManager = GridLayoutManager(this, 2)        // span count is the number of rows
        recyclerViewBoard.setHasFixedSize(true)

    }
}