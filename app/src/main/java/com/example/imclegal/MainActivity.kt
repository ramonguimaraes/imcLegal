package com.example.imclegal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener(View.OnClickListener {

            var sexo = "";
            var peso :Double = editPeso.text.toString().toDouble();
            var altura :Double = editAltura.text.toString().toDouble();

            var imc = peso/altura.pow(2);

            if ( radioFeme.isChecked ) {
                sexo = "feme";
            } else {
                sexo = "masc";
            }


            val intent = Intent(this, Main2Activity::class.java);
            intent.putExtra("imc", verificaImc(imc, sexo).toString());
            startActivity(intent);

        });
    }

    fun verificaImc(imc :Double, sexo :String) :String{
        var resultado = "";

        if (sexo == "masc") {

            resultado = if (imc >= 43.0) {
               getString(R.string.obesoMorbito);
            } else if (imc in 30.0..39.9) {
                getString(R.string.obesoModerado);
            } else if (imc in 25.0..29.9){
                getString(R.string.obesoLeve);
            } else if (imc in 20.0..24.9){
                getString(R.string.normal);
            } else if (imc < 20.0) {
                getString(R.string.abaixoDoNormal);
            } else {
                "deu ruim";
            }

        } else {

            resultado = if (imc >= 39.0) {
                getString(R.string.obesoMorbito);
            } else if (imc in 29.0..38.9) {
                getString(R.string.obesoModerado);
            } else if (imc in 24.0..28.9){
                getString(R.string.obesoLeve);
            } else if (imc in 19.0..23.9){
                getString(R.string.normal);
            } else if (imc < 19.0) {
                getString(R.string.abaixoDoNormal);
            } else {
                "deu ruim";
            }

        }

        return resultado;

    }

}
