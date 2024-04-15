package com.example.chatanywhere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatanywhere.Screens.LoginScreen
import com.example.chatanywhere.Screens.SignUp
import com.example.chatanywhere.Screens.term
import com.example.chatanywhere.ui.theme.ChatAnywhereTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAnywhereTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainController();
                }
            }
        }
    }
}

@Composable
fun MainController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Sign") {
        composable(route = "Sign") {
            SignUp(
                {
                    navController.navigate("terms/${it}")
                },
                {
                    navController.navigate("Login")
                }
            )
        }
        composable(route = "terms/{Name}", arguments = listOf(navArgument("Name") {
            type = NavType.StringType
        }
        )) {
            val nm = it.arguments!!.getString("Name")
            term(nm)
        }
        composable(route = "Login") {
            LoginScreen(
                {
                    navController.navigate("Sign")
                }
            )
        }
    }

}
