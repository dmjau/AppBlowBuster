package com.cursoandroid.appblowbuster

import android.view.View
import kotlin.random.Random

open class Peliculas(private var codigoIMDB: Int,
                     private var titulo: String,
                     private var fechaPublicacion: Int,
                     private var idiomaSubtitulos: String,
                     private var formatoPelicula: String): Producto (tipoProducto = TIPO_PRODUCTO, numeroProducto = obtenerNumeroProducto()) {

    companion object{
        private const val TIPO_PRODUCTO = "Pelicula"

        //Asigna numero de producto dentro de la categoria "pelicula"
        private fun obtenerNumeroProducto(): Int{
            return Random.nextInt(1, Int.MAX_VALUE)
        }
    }

    //open fun ingresarCodigoIMDB(view: View): Int{
        //var IMDB_code: Int = textView_form_codeIMDB_input.text.toInt()
        //return IMDB_code
    //}

    //fun mostrarTitulo(): String{
    //    return titulo
    //}

    //open fun ingresarFechaPublicacion(view: View): Int{
        //var publication_date: Int = textView_form_publicationDate_input.text.toInt()
        //return publication_date
    //}

    //open fun ingresarIdiomaSubtitulo(view: View): String{
        //var language_subtitle: String = textView_form_languageSubtitle_input.text.toString()
        //return language_subtitle
    //}

    //open fun ingresarFormato(view: View): String{
        //var format: String = textView_form_format_input.text.toString()
        //return format
    //}
}