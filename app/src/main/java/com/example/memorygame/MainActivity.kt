package com.example.memorygame

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygame.models.PictureAttributes
import com.example.memorygame.models.PicturesSize
import com.example.memorygame.pictures_folder.DEFAULT_ICON

private lateinit var recyclerViewBoard: RecyclerView
private lateinit var tvNoOfMoves: TextView
private lateinit var tvNoOfPairs: TextView

private var picturesSize: PicturesSize = PicturesSize.EASY    // we just used easy as an example


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewBoard = findViewById(R.id.recyclerViewBoard)
        tvNoOfMoves = findViewById(R.id.tvNoOfMoves)
        tvNoOfPairs = findViewById(R.id.tvNoOfPairs)

        //here we select the images to be displayed randomly at startup
        val randomisedImages = DEFAULT_ICON.shuffled().take(picturesSize.getNumPairs())
        val chosenImages = (randomisedImages + randomisedImages).shuffled()  // helps output pairs in twos

        var finalCardAttribute = chosenImages.map { PictureAttributes(it, false, false) } // or just use it since we are using the default value



        recyclerViewBoard.adapter = PicturesAdapter(this, picturesSize, finalCardAttribute)         // the total number of pieces
        recyclerViewBoard.setHasFixedSize(true)
        recyclerViewBoard.layoutManager = GridLayoutManager(this, picturesSize.getWidthOrNoOfPictures())        // span count is the number of rows


    }
}