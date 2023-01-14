package com.example.memorygame.models

// this data class creates all the attributes of a picture

data class PictureAttributes(
    val identifier : Int,       // id of the picture
    val isFacedUp: Boolean = false, // if the picture is faced up or not
    var isMatched: Boolean = false      // if we have found its pair

)