package com.example.memorygame.models

enum class PicturesSize (val numOfCards: Int){
    EASY(8),
    MEDIUM(18),
    HARD(24);

   fun getWidthOrNoOfPictures (): Int {
       return when (this){
           EASY -> 2
           MEDIUM -> 3
           HARD -> 4
       }
   }

    fun getHeight(): Int{
        return numOfCards / getWidthOrNoOfPictures()
    }

    fun getNumPairs (): Int{        // the cards are paired in twos so that's why we divide by two
        return numOfCards / 2
    }
}