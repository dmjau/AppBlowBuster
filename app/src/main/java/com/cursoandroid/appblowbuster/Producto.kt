package com.cursoandroid.appblowbuster

import kotlin.random.Random

abstract class Producto (protected val tipoProducto: String,
                        protected val numeroProducto: Int){

    companion object{
        private fun obtenerNumeroProducto(): Int{
            return Random.nextInt(1, Int.MAX_VALUE)
        }
    }
}