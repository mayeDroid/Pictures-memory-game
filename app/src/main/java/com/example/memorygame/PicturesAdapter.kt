package com.example.memorygame

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.memorygame.models.PictureAttributes
import com.example.memorygame.models.PicturesSize
import kotlin.math.min



class PicturesAdapter(
    private val context: Context,
    private val picturesSizeAdpt: PicturesSize,
    private val finalAttribute_Adpt: List<PictureAttributes>
) :
    RecyclerView.Adapter<PicturesAdapter.ViewHolder>() {



    companion object {      // he just decided to use 10, this will put a margin that separates pictures else the will be extremely close to each other
        private const val MARGIN_SIZE = 10  // The bigger the number, the wider the margin
        private const val TAG = "PicturesAdapter"
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        private val imageButton = itemView.findViewById<ImageView>(R.id.imageViewButton)

        fun bind(position: Int){

            imageButton.setImageResource(
                if (finalAttribute_Adpt[position].isFacedUp) {
                    finalAttribute_Adpt[position].identifier
                }
            else R.drawable.ic_launcher_background
                    )

            imageButton.setOnClickListener {
                Log.i(TAG, "You touched this $position")
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        // 2 pictures (rows) -> width, 4 pictures (column) -> height
        val pictureWidth = parent.width / picturesSizeAdpt.getWidthOrNoOfPictures()  - (2 * MARGIN_SIZE)   // without these the recycler view will not fit into the layout, so we need to get both size of width and height
        val pictureHeight = parent.height / picturesSizeAdpt.getHeight() - (2 * MARGIN_SIZE)
        val pictureSideLength = min(pictureWidth, pictureHeight)

       val view = LayoutInflater.from(context).inflate(R.layout.pictures_card, parent, false)

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

    override fun getItemCount() = picturesSizeAdpt.numOfCards




}
