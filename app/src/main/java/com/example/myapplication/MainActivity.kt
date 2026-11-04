package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private var inicio = 0L
    private var mensaje by mutableStateOf("")
    private val TAG = "Estados"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = mensaje, modifier = Modifier.padding(top = 64.dp, start = 16.dp))
        }
    }

    override fun onResume(){
        super.onResume()
        inicio = SystemClock.elapsedRealtime()
        mensaje = "Estoy en onResume"
        Log.d(TAG,"Estoy en onResume")
    }

    override fun onPause() {
        super.onPause()
        val duracion = SystemClock.elapsedRealtime() - inicio
        Log.d(TAG,"Estoy en onPause - Tiempo activo: $duracion ms")
        mensaje = "Estoy en onPause"
    }
}
