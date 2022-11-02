package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world!")
        }
    }
}

@Composable
fun Greeting(name: String) {

    val seleccion= mutableListOf("Malo", "Regular", "Bien", "Muy bien")
    val random = seleccion.random()
    var respuesta1 by remember { mutableStateOf("Malo") }
    var respuesta2 by remember { mutableStateOf("Regular") }
    var respuesta3 by remember { mutableStateOf("Bien") }
    var respuesta4 by remember { mutableStateOf("Muy bien") }
    var nombre by remember { mutableStateOf("Rafael") }
    var dia by remember { mutableStateOf("Martes") }
    var conjunto = 0
    var media by remember { mutableStateOf("Bien") }
    var cuadro by remember { mutableStateOf("¡Pulsa para ver como sera tu dia!")}


    fun countOccurrences(s: String, ch: Char): Int {
        return s.count { it == ch }
    }
    val nombremin = nombre.toLowerCase()
    val diamin = dia.toLowerCase()

    for (letra in nombremin){
        conjunto += countOccurrences(diamin,letra)
    }

    val res: Double = (conjunto.toDouble()/nombre.length.toDouble()) * 4.0

    if (res < 1){
        media = "Malo"
    }else if (res >= 1.0 && res < 2.0){
        media = "Regular"
    }else if (res >= 2.0 && res < 3.0){
        media = "Bien"
    }else if (res >= 3.0 && res < 4.0){
        media = "Muy Bien"
    }

    Column() {
        Text(text = "$name")
        Text(text = "Amor: $respuesta1")
        Text(text = "Dinero: $respuesta2")
        Text(text = "Salud: $respuesta3")
        Text(text = "Trabajo: $respuesta4")
        Text(text = "General: $media")
    }
    Column(modifier = Modifier
        .fillMaxHeight()
        .width(400.dp)
        .wrapContentWidth(Alignment.Start),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom) {
        Button(onClick = {
            if (random == respuesta1){
                val nuevo = seleccion.random()
                respuesta1 = nuevo
            }else{
                respuesta1 = random
            }
            if (random == respuesta2){
                val nuevo = seleccion.random()
                respuesta2 = nuevo
            }else{
                respuesta2 = random
            }
            if (random == respuesta3){
                val nuevo = seleccion.random()
                respuesta3 = nuevo
            }else{
                respuesta3 = random
            }
            if (random == respuesta4){
                val nuevo = seleccion.random()
                respuesta4 = nuevo
            }else{
                respuesta4 = random
            }
        }) {
            Text(cuadro)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Greeting("¿Cual es tu horoscopo de hoy?")
    }
}