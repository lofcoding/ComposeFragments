package com.example.composefragments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import com.example.composefragments.ui.theme.ComposeFragmentsTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFragmentsTheme {
                HomeScreen(
                    username = "Lofcoding",
                    navigateToProfileScreen = {
                        println("test navigate to profile")
                    }
                )
            }
        }
    }
}