package com.example.maimathandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.maimathandroid.ui.theme.MaiMathAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaiMathAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MaiMath()
                }
            }
        }
    }
}
fun handle(n:Int)
{
    println(n)
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MaiMath() {
    Column(modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            "Mai's Math",
            fontSize = 40.sp,
            color = Color.Gray,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Text(
            "8+6",
            fontSize = 80.sp,
            color = Color.Blue,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        Text(
            "0",
            fontSize = 120.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        var ns = arrayOf("0","1","2","+","3","4","5","-",
            "6","7","8","×","9",".","=","÷")
        for(i in 0 until ns.size/4)
        {
            Row (modifier = Modifier.fillMaxWidth().padding(all=10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ){

                for(j in 0..3)
                {
                    Button(onClick = {handle(i*4+j)},
                        modifier = Modifier.size(width = 80.dp, height = 60.dp)){
                        Text(ns[i*4+j], fontSize = 30.sp)
                    }
                }
            }
        }
    }
}
