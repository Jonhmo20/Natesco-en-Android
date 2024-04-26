package com.example.natesco

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.natesco.ui.theme.NatescoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NatescoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    MyButton(context = this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Natesco $name!",
        modifier = modifier
    )
}

@Composable
fun MyButton(context: Context) {
    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp, vertical = 16.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
             Image(
            painter = painterResource(id = R.drawable.natesco),
            contentDescription = "Imagen",
            modifier = Modifier
                .size(500.dp)
                .padding(bottom = 16.dp)
             )
            Spacer(modifier = Modifier.height(2.dp))
            Box(
            modifier = Modifier
                .height(64.dp) // Altura del botón
                .fillMaxWidth(), // Ancho del botón
            contentAlignment = Alignment.Center // Centrar el contenido dentro del Box
            ) {
            Button(
                onClick = { mostrarToast(context = context, message = "¡Bienvenido a Natesco!") },
                modifier = Modifier.fillMaxSize(),
                 ) {
                Text(text = "Entrar")
                }
        }
    }
}

fun mostrarToast(context: Context?, message: String) {
        context?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtontPreview() {
    NatescoTheme {
        MyButton(context = LocalContext.current)
    }
}