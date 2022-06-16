package com.getworld.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // brliblioteca inserida para recuperação de texto id("org.jetbrains.kotlin.android.extensions") version "1.7.0"

    fun calcularPreco(view: View){

        //recuperar os valores digitados sem a extenção kottlin
        //val precoAlcool = findViewById<EditText>(R.id.editPrecoAlcool)

        //recuperando valores digitado com a exteção kottlin
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        //validando campos
        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if (validaCampos){

            calcularMelhorPreco(precoAlcool, precoGasolina)

        }else{
            textResultado.text = "Preencha  os preços primeiro!!"
        }



    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        //Converter String para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*Faz Cálculo (precoAlcool / precoGasolina)
        * *Se resultado >= 0.7 melhor utilizar gasolina
        * senão melhor utilizar Alcool
        * */

        val  resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7 ){
            textResultado.text = "Melhor utilizar Gasolina..."
        }else{

            textResultado.text = "Melhor utilizar Alcool."
        }


    }

    //criando o metodos de validar campos
    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean{

        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")){

            camposValidados = false
        }else if (precoGasolina == null || precoGasolina.equals("")){

            camposValidados = false
        }

        return camposValidados


    }
}