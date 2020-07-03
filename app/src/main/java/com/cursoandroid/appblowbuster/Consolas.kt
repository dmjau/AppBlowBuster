package com.cursoandroid.appblowbuster

import kotlin.random.Random

open class Consolas(private var Marca: String, private var Modelo_consola: String): Producto (tipoProducto = TIPO_PRODUCTO, numeroProducto = obtenerNumeroProducto()) {

    companion object{
        private const val TIPO_PRODUCTO = "Consola"

        //Asigna numero de producto dentro de la categoria "Consola"
        private fun obtenerNumeroProducto(): Int{
            return Random.nextInt(1, Int.MAX_VALUE)
        }
    }
}