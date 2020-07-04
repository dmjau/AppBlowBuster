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
                    button_main_search.setOnClickListener {
                        productSelector(items_productos_disponibles[position])
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some act
                }
            }

        }
    }


    private fun btnSearchMain (){
        if(editText_main_search.text.isEmpty()){
            Toast.makeText(this, "Ingrese el Titulo de una Pelicula", Toast.LENGTH_LONG).show()
        } else {
            val text_input_search = editText_main_search.text.toString()
            Arreglo_DVD.forEach{
                var tituloObtenido = it.titulo_DVD
                println(tituloObtenido)
                Toast.makeText(this, text_input_search + tituloObtenido, Toast.LENGTH_LONG).show()
            }
            Toast.makeText(this, text_input_search, Toast.LENGTH_LONG).show()
        }
    }

    private fun productSelector(selection: String){
        when (selection) {
            "DVD" -> {
                Toast.makeText(this, "seleccion DVD", Toast.LENGTH_LONG).show()
                searchDVDtitle()
            }
            "BluRay" -> Toast.makeText(this, "seleccion BluRay", Toast.LENGTH_LONG).show()
            "VHS" -> Toast.makeText(this, "seleccion VHS", Toast.LENGTH_LONG).show()
            "PS4" -> Toast.makeText(this, "seleccion PS4", Toast.LENGTH_LONG).show()
            "XboxOne" -> Toast.makeText(this, "seleccion Xbox One", Toast.LENGTH_LONG).show()
        }
    }

    private fun searchDVDtitle(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_DVD.forEach{
            var tituloGuardado = it.titulo_DVD
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                textView_main_results1.text = "TITULO: " + tituloGuardado
                textView_main_results2.text = "Numero de Zona: " + it.numeroDeZona_DVD.toString()
                textView_main_results3.text = "Codigo IMBD: " + it.codigoIMBD_DVD.toString()
                textView_main_results4.text = "Fecha de Publicacion: " + it.fechaPublicacion_DVD.toString()
                textView_main_results5.text = "Idioma de Subtitulo: " + it.idiomaSubtitulos_DVD

            }
        }
    }




    private val DVD1 = Dvd(100, 1234, "matrix", 2003, "Spanish", true)
    private val DVD2 = Dvd(101, 5678, "titanic", 2005, "Portugues", false)
    private val VHS1 = Vhs(1995, 9090, "Tiburon", 1980, "Spanish", true)
    private val VHS2 = Vhs(1992, 2928, "El Padrino", 1887, "English", false)
    private val BluRay1 = BluRay(1234, "Avatar", 2010, "English", true)
    private val BluRay2 = BluRay(2323, "Gladiador", 2008, "English", false)
    private val Consola1 = Consolas("Sony", "PS4", true)
    private val Consola2 = Consolas("Nintendo", "Xbox One", false)

    val Arreglo_DVD: MutableList<Dvd> = mutableListOf(DVD1, DVD2)
    val Arreglo_VHS: MutableList<Vhs> = mutableListOf(VHS1, VHS2)
    val Arreglo_BluRay: MutableList<BluRay> = mutableListOf(BluRay1, BluRay2)
    val Arreglo_Consolas: MutableList<Consolas> = mutableListOf(Consola1, Consola2)






}
