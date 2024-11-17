package com.example.buttleships

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buttleships.ui.theme.ButtleshipsTheme

data class player(
       val playerId: String = "",
        var name: String = "",
        var status: String = "offline",
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtleshipsTheme {
                dataBase.MakeListner()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "firstScreen" , builder = {
                    composable(nav.firstScreen) {
                        firstScreen(navController = navController)
                    }
                    composable(nav.secondScreen) {
                        secondScreen(navController = navController)
                    }
                    composable(nav.lobby) {
                        lobby(navController = navController)
                    }
                    composable (nav.mainGame) {
                        MainGame(navController = navController)
                    }
                })



            }
        }
    }
}





@Preview
@Composable
fun GreetingPreview1() {
    ButtleshipsTheme {
        MainGame( navController = rememberNavController())
    }
}