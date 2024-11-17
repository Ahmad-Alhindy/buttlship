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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buttleships.ui.theme.ButtleshipsTheme
import kotlinx.coroutines.flow.asStateFlow


class MyBox(var columnNumber: Int = 0,
            var rowNumber: Int = 0)
             {
    @Composable
    fun MyComposableBox() {
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.White)
                .size(34.dp)
        )  {
            Text(text = rowNumber.toString(), color = Color.White)
            Text(text = columnNumber.toString(), color = Color.White, modifier = Modifier.align(Alignment.Center))
        }
    }
}



@Composable
fun MainGame (navController: NavController) {
    val BoxList = remember { mutableStateListOf<MyBox>() }
    val players by dataBase.playerList.asStateFlow().collectAsStateWithLifecycle()

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
            Box(
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
                // Overlaying the content you want on top
                Column {
                    for (i in 0 until 11) {
                        Row {
                            if (i > 0) {
                                Text(
                                    text = (i - 1).toString(),
                                    color = Color.White,
                                    modifier = Modifier.padding(end = 10.dp)
                                )
                            }
                            for (j in 1 until 11) {
                                if (i == 0) {
                                    Text(
                                        text = (j - 1).toString(),
                                        color = Color.White,
                                        modifier = Modifier.padding(start = 25.dp)
                                    )
                                }
                                else{
                                    val myBox = MyBox(j, i)
                                    BoxList.add(myBox)
                                    myBox.MyComposableBox()
                                }
                            }
                        }
                    }
                }

                // This Image will be on the "background" layer.
                Image(
                    painter = painterResource(R.drawable.ship1),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(350.dp,400.dp)
                )
//                Image(
//                    painter = painterResource(R.drawable.ship2),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//                Image(
//                    painter = painterResource(R.drawable.ship3),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//                Image(
//                    painter = painterResource(R.drawable.ship4),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//                Image(
//                    painter = painterResource(R.drawable.ship5),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
            }
        }
    }
}


@Preview
@Composable
fun MainGamePreview() {
    ButtleshipsTheme {
        MainGame( navController = rememberNavController())
    }
}