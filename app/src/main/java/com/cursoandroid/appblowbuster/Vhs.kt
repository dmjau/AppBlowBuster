package com.cursoandroid.appblowbuster

class Vhs (protected var fechaDeFabricacion_VHS: Int,
           var codigoIMBD_VHS: Int,
           var titulo_VHS: String,
           var fechaPublicacion_VHS: Int,
           var idiomaSubtitulos_VHS: String,
           var estado_VHS: Boolean): Peliculas(codigoIMDB = codigoIMBD_VHS, titulo = titulo_VHS, fechaPublicacion = fechaPublicacion_VHS, idiomaSubtitulos = idiomaSubtitulos_VHS, formatoPelicula = FORMATO_PELICULA ) {

    companion object{
        private const val FORMATO_PELICULA = "VHS"
    }

}