package com.cursoandroid.appblowbuster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializo el array en un valor
        val items_productos_disponibles = resources.getStringArray(R.array.products)

        //accedo al spinner (desplegable)
        val spinner_main = findViewById<Spinner>(R.id.spinner_main)

        //logica de toma de elementos del spinner
        if(spinner_main != null){
            val adapter = ArrayAdapter(this, R.layout.textview_spinner, items_productos_disponibles)

            spinner_main.adapter = adapter

            spinner_main.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    //Toast.makeText(this@MainActivity, getString(R.string.txt_select) + " " + "" + items_productos_disponibles[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        }

        button_main_search.setOnClickListener {
            btnSearchMain()
        }

    }


    private fun btnSearchMain (){
        if(editText_main_search.text.isEmpty()){
            Toast.makeText(this, "Ingrese el Titulo de una Pelicula", Toast.LENGTH_LONG).show()
        } else {
            val text_input_search = editText_main_search.text.toString()
            for (i in 0 until Arreglo_DVD.size){
                Arreglo_DVD.forEach{
                    it.titulo_DVD
                }
            }
            Toast.makeText(this, text_input_search, Toast.LENGTH_LONG).show()
        }
    }

    private val DVD1 = Dvd(100, 1234, "Matrix 1", 2003, "Spanish")
    private val DVD2 = Dvd(101, 5678, "Titanic", 2005, "Portugues")
    private val VHS1 = Vhs(1995, 9090, "Tiburon", 1980, "Spanish")
    private val VHS2 = Vhs(1992, 2928, "El Padrino", 1887, "English")
    private val BluRay1 = BluRay(1234, "Avatar", 2010, "English")
    private val BluRay2 = BluRay(2323, "Gladiador", 2008, "English")
    private val Consola1 = Consolas("Sony", "PS4")
    private val Consola2 = Consolas("Nintendo", "Xbox One")

    val Arreglo_DVD: MutableList<Dvd> = mutableListOf(DVD1, DVD2)
    val Arreglo_VHS: MutableList<Vhs> = mutableListOf(VHS1, VHS2)
    val Arreglo_BluRay: MutableList<BluRay> = mutableListOf(BluRay1, BluRay2)
    val Arreglo_Consolas: MutableList<Consolas> = mutableListOf(Consola1, Consola2)

    private fun buscarEnArregloDVD(){
        for (i in 0 until Arreglo_DVD.size){
            Arreglo_DVD.forEach{
                it.titulo_DVD
                println("$it")
            }
        }
    }





}
