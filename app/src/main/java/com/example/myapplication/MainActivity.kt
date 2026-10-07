package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        // Título centrado
        Text(
            text = "TEAM GATITOS TIERNOS",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 16.dp)
        )

        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )

        // Jugador 1
        Jugador(
            nombre = "Alfred67",
            rol = "Atacante",
            edad = 26,
            nivel = 87,
            imagen = R.drawable.alfred67
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

        // Jugador 2
        Jugador(
            nombre = "Funny Valentine",
            rol = "Defensor",
            edad = 24,
            nivel = 91,
            imagen = R.drawable.funnyvalentine
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

        // Jugador 3
        Jugador(
            nombre = "HorseGiirl",
            rol = "Soporte",
            edad = 20,
            nivel = 84,
            imagen = R.drawable.horsegiirl
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

        // Jugador 4
        Jugador(
            nombre = "KittyCat32",
            rol = "Atacante",
            edad = 23,
            nivel = 89,
            imagen = R.drawable.kittycat32
        )
        HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)
    }
}

//Composanle para cada jugador individual
@Composable
fun Jugador(
    nombre: String,
    rol: String,
    edad: Int,
    nivel: Int,
    @DrawableRes imagen: Int

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
       //Imagen circular
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "Foto de $nombre",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        //Datos del Jugador
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Rol: $rol",
                fontSize = 14.sp
            )
            Text(
                text = "Edad: $edad años",
                fontSize = 14.sp
            )
            Text(
                text = "Nivel: $nivel",
                fontSize = 14.sp
            )
        }
    }
}

//Preview para ver un jugador en el editor
@Preview(showBackground = true)
@Composable
fun JugadorPreview() {
    Jugador(
        nombre = "Alfred67",
        rol = "Atacante",
        edad = 26,
        nivel = 87,
        imagen = R.drawable.alfred67
    )
}