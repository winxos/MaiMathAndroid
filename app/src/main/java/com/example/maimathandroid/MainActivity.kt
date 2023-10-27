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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        var ans by remember{mutableStateOf("0")}
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
            ans,
            fontSize = 120.sp,
            color = Color.DarkGray,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
        var ns = arrayOf("7","8","9","+","4","5","6","-",
            "1","2","3","×","0","←","=","÷")
        for(i in 0 until ns.size/4)
        {
            Row (modifier = Modifier.fillMaxWidth().padding(all=10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ){

                for(j in 0..3)
                {
                    var k = i*4+j
                    Button(onClick = {
                        handle(k)
                        if(ns[k] == "←")
                        {
                            if(ans.length>1)
                            {
                                ans = ans.substring(0,ans.length-1)
                            }
                            else
                            {
                                ans = "0"
                            }
                        }
                        else
                        {
                            ans+=ns[k]
                        }
                        },
                        modifier = Modifier.size(width = 80.dp, height = 60.dp)){
                        Text(ns[k], fontSize = 30.sp)
                    }
                }
            }
        }
    }
}
