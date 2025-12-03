package com.rishiritesh.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rishiritesh.composeplayground.playground.CatalogScreen
import com.rishiritesh.composeplayground.playground.demos.animatedbutton.AnimatedButtonScreen
import com.rishiritesh.composeplayground.playground.demos.complexlazy.ComplexLazyScreen
import com.rishiritesh.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // tiny in-memory navigation state
                    var currentRoute by remember { mutableStateOf("catalog") }

                    when (currentRoute) {
                        "catalog" -> {
                            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                                CatalogScreen(
                                    modifier = Modifier.padding(innerPadding),
                                    onOpenDemo = { demoId ->
                                        currentRoute = demoId
                                    }
                                )
                            }
                        }

                        "complex_lazy" -> {
                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text("Complex LazyColumn") },
                                        navigationIcon = {
                                            IconButton(onClick = { currentRoute = "catalog" }) {
                                                Icon(
                                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                                    contentDescription = "Back"
                                                )
                                            }
                                        }
                                    )
                                }
                            ) { innerPadding ->
                                ComplexLazyScreen(
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }

                        "animated_button" -> {
                            // simple demo screen with a back button
                            Scaffold(
                                topBar = {
                                    TopAppBar(
                                        title = { Text("Animated Button") },
                                        navigationIcon = {
                                            IconButton(onClick = { currentRoute = "catalog" }) {
                                                Icon(
                                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                                    contentDescription = "Back"
                                                )
                                            }
                                        }
                                    )
                                }

                            ) { innerPadding ->
                                AnimatedButtonScreen(
                                    modifier = Modifier.padding(innerPadding)
                                )
                            }
                        }

                        else -> {
                            // fallback: go back to catalog
                            currentRoute = "catalog"
                        }
                    }
                }
            }
        }

    }
}
