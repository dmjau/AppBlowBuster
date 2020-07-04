package com.cursoandroid.appblowbuster

import kotlin.random.Random

open class Consolas(var marca: String,
                    var modelo_consola: String,
                    var estado_Consola: Boolean): Producto (tipoProducto = TIPO_PRODUCTO, numeroProducto = obtenerNumeroProducto()) {

    companion object{
        private const val TIPO_PRODUCTO = "Consola"

        //Asigna numero de producto dentro de la categoria "Consola"
        private fun obtenerNumeroProducto(): Int{
            return Random.nextInt(1, Int.MAX_VALUE)
        }
    }
}