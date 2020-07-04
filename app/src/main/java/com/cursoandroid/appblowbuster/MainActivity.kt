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
                        clearResults()
                        when (items_productos_disponibles[position]) {
                            "DVD" -> {
                                if (verifySearchField()){
                                    searchDVDtitle()
                                }
                            }
                            "BluRay" -> {
                                if (verifySearchField()){
                                    searchBluRaytitle()
                                }
                            }
                            "VHS" -> {
                                if (verifySearchField()){
                                    searchVHStitle()
                                }
                            }
                            "PS4" -> searchConsola(items_productos_disponibles[position])
                            "XboxOne" -> searchConsola(items_productos_disponibles[position])
                        }
                    }
                    button_main_state.setOnClickListener {
                        when (items_productos_disponibles[position]) {
                            "DVD" -> {
                                if (verifySearchField()){
                                    changeStateDVD()
                                }
                            }
                            "BluRay" -> {
                                if (verifySearchField()){
                                    changeStateBluRay()
                                }
                            }
                            "VHS" -> {
                                if (verifySearchField()){
                                    changeStateVHS()
                                }
                            }
                            "PS4" -> changeStateConsola(items_productos_disponibles[position])
                            "XboxOne" -> changeStateConsola(items_productos_disponibles[position])
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some act
                }
            }

        }

    }



    //-----------------medtodos para DVD-----------------
    private fun searchDVDtitle(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_DVD.forEach{
            var tituloGuardado = it.titulo_DVD
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                textView_main_results1.text = "TITULO: " + it.titulo_DVD
                textView_main_results2.text = "Numero de Zona: " + it.numeroDeZona_DVD
                textView_main_results3.text = "Codigo IMBD: " + it.codigoIMBD_DVD
                textView_main_results4.text = "Fecha de Publicacion: " + it.fechaPublicacion_DVD
                textView_main_results5.text = "Idioma de Subtitulo: " + it.idiomaSubtitulos_DVD
                textView_main_results6.text = stateVerify(it.estado_DVD)
            }
        }
    }
    fun changeStateDVD(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_DVD.forEach{
            var tituloGuardado = it.titulo_DVD
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                it.estado_DVD = changeState(it.estado_DVD)
                textView_main_results6.text = stateVerify(it.estado_DVD)
            }
        }
    }

    //-----------------medtodos para BluRay-----------------
    private fun searchBluRaytitle(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_BluRay.forEach{
            var tituloGuardado = it.titulo_BluRay
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                textView_main_results1.text = "TITULO: " + it.titulo_BluRay
                textView_main_results2.text = "Numero IMBD: " + it.codigoIMBD_BluRay
                textView_main_results3.text = "Fecha de Publicacion: " + it.fechaPublicacion_BluRay
                textView_main_results4.text = "Idioma de Subtitulo: " + it.idiomaSubtitulos_BluRay
                textView_main_results6.text = stateVerify(it.estado_BluRay)
            }
        }
    }

    fun changeStateBluRay(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_BluRay.forEach{
            var tituloGuardado = it.titulo_BluRay
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                it.estado_BluRay = changeState(it.estado_BluRay)
                textView_main_results6.text = stateVerify(it.estado_BluRay)
            }
        }
    }

    //-----------------Metodos para VHS----------------------
    private fun searchVHStitle(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_VHS.forEach{
            var tituloGuardado = it.titulo_VHS
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                textView_main_results1.text = "TITULO: " + it.titulo_VHS
                textView_main_results2.text = "Numero IMBD: " + it.codigoIMBD_VHS
                textView_main_results3.text = "Fecha de Publicacion: " + it.fechaPublicacion_VHS
                textView_main_results4.text = "Idioma de Subtitulo: " + it.idiomaSubtitulos_VHS
                textView_main_results5.text = "Fecha de Fabricacion: " + it.fechaDeFabricacion_VHS
                textView_main_results6.text = stateVerify(it.estado_VHS) + " dentro del VideoClub"
                Toast.makeText(this, R.string.txt_warning, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun changeStateVHS(){
        val tituloABucar = editText_main_search.text.toString()
        Arreglo_VHS.forEach{
            var tituloGuardado = it.titulo_VHS
            var i = tituloGuardado.contentEquals(tituloABucar)
            if( i ){
                it.estado_VHS = changeState(it.estado_VHS)
                textView_main_results6.text = stateVerify(it.estado_VHS)
            }
        }
    }

    //-----------------Metodos para Consolas--------------------------------------------------------
    private fun searchConsola(tipoDeConsola: String){
        Arreglo_Consolas.forEach{
            var modeloDeConsola = it.modelo_consola
            var i = modeloDeConsola.contentEquals(tipoDeConsola)
            if( i ){
                textView_main_results1.text = "Marca: " + it.marca
                textView_main_results2.text = "Modelo: " + it.modelo_consola
                textView_main_results6.text = stateVerify(it.estado_Consola)
            }
        }
    }

    fun changeStateConsola(tipoDeConsola: String){
        Arreglo_Consolas.forEach{
            var modeloDeConsola = it.modelo_consola
            var i = modeloDeConsola.contentEquals(tipoDeConsola)
            if( i ){
                it.estado_Consola = changeState(it.estado_Consola)
                textView_main_results6.text = stateVerify(it.estado_Consola)
            }
        }
    }


    //--------------------Metodos comunes a todas las listas-----------------------------------
    fun verifySearchField(): Boolean{
        if(editText_main_search.text.isEmpty()){
            Toast.makeText(this, "Ingrese el Titulo de una Pelicula", Toast.LENGTH_LONG).show()
        } else {
            return true
        }
        return false
    }

    fun stateVerify(estadoObjeto: Boolean): String{
        if (estadoObjeto){
            return "DISPONIBLE"
        }
        return "EN USO"
    }

    fun changeState(estadoActual: Boolean): Boolean{
        if (estadoActual){
            return false
        }
        return true
    }
    fun clearResults(){
        textView_main_results1.text = ""
        textView_main_results2.text = ""
        textView_main_results3.text = ""
        textView_main_results4.text = ""
        textView_main_results5.text = ""
        textView_main_results6.text = ""
    }


    //-----------------------------Arreglos---------------------------------------------------------
    private val DVD1 = Dvd(100, 1234, "matrix", 2003, "Spanish", true)
    private val DVD2 = Dvd(101, 5678, "titanic", 2005, "Portugues", false)
    private val DVD3 = Dvd(404, 7645, "starwars", 2005, "Spanish", false)
    private val VHS1 = Vhs(1995, 9090, "tiburon", 1980, "Spanish", true)
    private val VHS2 = Vhs(1992, 2928, "el padrino", 1887, "English", false)
    private val VHS3 = Vhs(1994, 2121, "back to the future", 1990, "Spanish", true)
    private val BluRay1 = BluRay(1234, "avatar", 2010, "English", true)
    private val BluRay2 = BluRay(2323, "gladiador", 2008, "English", false)
    private val BluRay3 = BluRay(4545, "batman", 2018, "Spanish", true)
    private val Consola1 = Consolas("Sony", "PS4", true)
    private val Consola2 = Consolas("Nintendo", "XboxOne", false)

    val Arreglo_DVD: MutableList<Dvd> = mutableListOf(DVD1, DVD2, DVD3)
    val Arreglo_VHS: MutableList<Vhs> = mutableListOf(VHS1, VHS2, VHS3)
    val Arreglo_BluRay: MutableList<BluRay> = mutableListOf(BluRay1, BluRay2)
    val Arreglo_Consolas: MutableList<Consolas> = mutableListOf(Consola1, Consola2)
}
