package com.cursoandroid.appblowbuster

class BluRay(var codigoIMBD_BluRay: Int,
             var titulo_BluRay: String,
             var fechaPublicacion_BluRay: Int,
             var idiomaSubtitulos_BluRay: String): Peliculas(codigoIMDB = codigoIMBD_BluRay, titulo = titulo_BluRay, fechaPublicacion = fechaPublicacion_BluRay, idiomaSubtitulos = idiomaSubtitulos_BluRay, formatoPelicula = FORMATO_PELICULA ) {

    companion object{
        private const val FORMATO_PELICULA = "BluRay"
    }

}