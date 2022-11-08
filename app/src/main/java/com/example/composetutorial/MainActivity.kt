package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import java.sql.RowId


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
    val nombre by remember { mutableStateOf("Rafael") }
    val diasemana = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    var dia by remember { mutableStateOf(diasemana.random()) }
    var conjunto = 0
    var media by remember { mutableStateOf("Bien") }
    var respuesta1 by remember { mutableStateOf(seleccion.random()) }
    var respuesta2 by remember { mutableStateOf(seleccion.random()) }
    var respuesta3 by remember { mutableStateOf(seleccion.random()) }
    var respuesta4 by remember { mutableStateOf(seleccion.random()) }
    val selale = seleccion.random()


    fun countOccurrences(s: String, ch: Char): Int {
        return s.count { it == ch }
    }
    val nombremin = nombre.lowercase()
    val diamin = dia.lowercase()

    for (letra in nombremin){
        conjunto += countOccurrences(diamin,letra)
    }

    val res: Double = (conjunto.toDouble()/nombre.length.toDouble()) * 4.0

    if (res < 1.0){
        media = "Malo"
    }else if (res >= 1.0 && res < 2.0){
        media = "Regular"
    }else if (res >= 2.0 && res < 3.0){
        media = "Bien"
    }else if (res >= 3.0 && res < 4.0){
        media = "Muy Bien"
    }
    Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.f_elconfidencial_com_original_d91_12f_bdb_d9112fbdb40bca66c3f3ebf4e7e8644c),
                contentDescription = "Imagen del horoscopo",
                modifier = Modifier
                    .size(65.dp)
                    .clip(CircleShape)
                    .clickable {  if (selale == respuesta1){
                        val nuevo = seleccion.random()
                        respuesta1 = nuevo
                    }else{
                        respuesta1 = selale
                    }
                        if (selale == respuesta2){
                            val nuevo = seleccion.random()
                            respuesta2 = nuevo
                        }else{
                            respuesta2 = selale
                        }
                        if (selale == respuesta3){
                            val nuevo = seleccion.random()
                            respuesta3 = nuevo
                        }else{
                            respuesta3 = selale
                        }
                        if (selale == respuesta4){
                            val nuevo = seleccion.random()
                            respuesta4 = nuevo
                        }else{
                            respuesta4 = selale
                        } }
            )
        }
        Spacer(modifier = Modifier.width(8.dp),)
        Column(modifier = Modifier
                .fillMaxHeight()
                .width(400.dp)
                .wrapContentWidth(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$name")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Amor: $respuesta1")
            Text(text = "Dinero: $respuesta2")
            Text(text = "Salud: $respuesta3")
            Text(text = "Trabajo: $respuesta4")
            Text(text = "General: $media")
            Text(text = "El dia de hoy es: $dia")
        }
    }

@Preview(showBackground = true)
@Preview(
uiMode = Configuration.UI_MODE_NIGHT_YES,
showBackground = true,
name = "Dark Mode")
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Greeting("¿Cual es tu horoscopo de hoy?")
    }
}