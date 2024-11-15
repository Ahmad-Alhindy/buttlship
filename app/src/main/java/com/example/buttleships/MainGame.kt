package com.example.buttleships

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

class MyBox(var columnNumber: Int = 0, var rowNumber: Int = 0) {
    @Composable
    fun MyComposableBox() {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.White)
                .size(34.dp)
        ) {
            // You can use the 'number' property here if needed
            Text(text = rowNumber.toString(), color = Color.White)
            Text(text = columnNumber.toString(), color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
    }
}



@Composable
fun MainGame (navController: NavController) {
    Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {// the box is allow you to have multiple things over each other
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .size(
                        width = 380.dp,
                        height = 100.dp
                    )
                    .padding(20.dp)
                    .background(Color.Black.copy(alpha = 0.5f)) // making the background transparent
                    .align(Alignment.TopCenter)
            ) {
                Text(
                    text = "Name: ",
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    color = Color.White
                )
                Text(
                    text = "Score: 0-0",
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp),
                    color = Color.White,

                    )
            }
            Column(
                modifier = Modifier
                    .size(
                        width = 400.dp,
                        height = 454.dp
                    )
                    .padding(10.dp)
                    .padding(bottom = 40.dp)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .align(Alignment.BottomCenter)
            ) {
                for (i in 0 until 11) {
                    Row {

                       if(i > 0) {
                           Text(
                               text = (i- 1).toString(),
                               color = Color.White,
                               modifier = Modifier.padding(end = 10.dp)
                           )
                       }
                        for (j in 1 until 11) {
                            if (i == 0) {
                                Text(
                                    text = (j-1).toString(),
                                    color = Color.White,
                                    modifier = Modifier.padding(start = 25.dp)
                                )
                            }
                            else {
                                val myBox = MyBox(j, i)
                                myBox.MyComposableBox()
                            }
                        }
                    }
                }
            }
        }
    }
}
