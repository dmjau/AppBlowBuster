package com.cursoandroid.appblowbuster

import android.view.View

class Dvd (protected var NumeroDeZona_DVD: Int,
           var codigoIMBD_DVD: Int,
           var titulo_DVD: String,
           var fechaPublicacion_DVD: Int,
           var idiomaSubtitulos_DVD: String): Peliculas(codigoIMDB = codigoIMBD_DVD, titulo = titulo_DVD, fechaPublicacion = fechaPublicacion_DVD, idiomaSubtitulos = idiomaSubtitulos_DVD, formatoPelicula = FORMATO_PELICULA ) {

    companion object{
        private const val FORMATO_PELICULA = "DVD"
    }

    fun mostrarTitulo(): String{
        return titulo_DVD
    }

}