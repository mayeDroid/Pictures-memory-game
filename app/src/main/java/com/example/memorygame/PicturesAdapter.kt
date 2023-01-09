package com.example.memorygame

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class PicturesAdapter(private val context: Context, private val numberOfPictures: Int) :
    RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {

        inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(position: Int){

            }
        }

    companion object {      // he just decided to use 10, this will put a margin that separates pictures else the will be extremely close to each other
        private const val MARGIN_SIZE = 10  // The bigger the number, the wider the margin
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        // 2 pictures (rows) -> width, 4 pictures (column) -> height
        val pictureWidth = parent.width / 2  - (2 * MARGIN_SIZE)   // without these the recycler view will not fit into the layout, so we need to get both size of width and height
        val pictureHeight = parent.height / 4 - (2 * MARGIN_SIZE)
        val pictureSideLength = min(pictureWidth, pictureHeight)

       val view = LayoutInflater.from(context).inflate(R.layout.pictures, parent, false)

        // now we want to get the actual height and width from the inflated layout
        val layOutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layOutParams.height = pictureSideLength
        layOutParams.width = pictureSideLength
        layOutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount() = numberOfPictures


}
