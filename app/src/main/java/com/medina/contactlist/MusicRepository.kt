package com.medina.contactlist

import com.medina.contactlist.model.Music

class MusicRepository (private val musics:MutableList<Music> = ArrayList()){

    init {
        getDataMusics()
    }

    fun getDataMusics(): List<Music> {
        musics.add(Music(100, "Un Vino Una Cerveza", "Pedro Suarez","Rock" ,"imag_1"))
        musics.add(Music(200, "Los Malaventurados No Lloran", "PXNDX","Rock" ,"imag_2"))
        musics.add(Music(300, "Virgen", "Los Adolescentes", "Salsa","imag_3"))
        musics.add(Music(400, "The Worst", "Jhené Alko","Pop" ,"imag_4"))
        musics.add(Music(500, "A Thousand Years", "Christina Perri", "Pop","imag_5"))
        musics.add(Music(600, "Angel", "The Weeknd", "Rap","imag_6"))
        musics.add(Music(700, "Boyfriend", "Big Time Rush", "Pop","imag_7"))
        musics.add(Music(800, "Sorry", "Justin Biber", "Pop","imag_8"))
        musics.add(Music(900, "Stitches", "Shawn Mendez","Pop" ,"imag_9"))
        musics.add(Music(1000, "Hello", "Adele", "Pop","imag_10"))
        return musics
    }
}
