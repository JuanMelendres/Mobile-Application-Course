package com.itesm.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2 categorias de variables

        // constante
        // declaracion con tipo explicito
        val constante : Int = 2
        // declaracion con tipo implicito
        val constante2 = 3

        // variable
        var variable : String = "HOLA"
        variable = "siempre no"

        // string templates
        var ejemplo = "el valor de variable es: $variable, ${1 + 2}"

        Log.wtf("PRUEBAS", ejemplo)
        Log.wtf("PRUEBAS", "${cuadrado(2)}")
        Log.wtf("PRUEBAS", "${multiplicacion(2, 3)}")

        // parametros con valor default
        Log.wtf("PRUEBAS", "${resta(3)}")
        Log.wtf("PRUEBAS", "${resta(3, 2)}")

        // invocacion utilizando parametros nombrados
        Log.wtf("PRUEBAS", "${resta(3, b = 2)}")

        // non-nullable
        var noNulo : String = "NO SOY NULL"
        // noNulo = null // error de compilacion

        // nullable
        var siNulo : String? = "SI FUI NULO"
        siNulo = null

        // solucion 1: checar si es null o no
        if(siNulo != null){
            Log.wtf("PRUEBAS", "$siNulo");
        }

        // safe calls
        Log.wtf("PRUEBAS", "${siNulo?.length}")

        // elvis operator
        // inline if para nulls
        // ?:

        var elvis = siNulo?.length ?: -1
    }

    // declaracion de funciones
    fun cuadrado(numero : Int) : Int {
        return numero * numero
    }

    // retorno con tipo inferido
    fun multiplicacion(a : Int, b : Int) = a * b

    // parametros default
    fun resta(a : Int, b : Int = 0) : Int{
        return a - b
    }
}
