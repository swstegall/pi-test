package me.stegall.pitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.stegall.pitest.ui.screens.AboutScreen
import me.stegall.pitest.ui.screens.MainScreen
import me.stegall.pitest.ui.screens.digits
import me.stegall.pitest.ui.theme.PiTestTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      var displayedText by remember { mutableStateOf("3.") }
      var currentIndex by remember { mutableStateOf(0) }
      var loseDialogOpen by remember { mutableStateOf(false) }
      var nextFive by remember { mutableStateOf("") }

      PiTestTheme {
        Scaffold {
          Surface(
            modifier = Modifier.fillMaxSize(),
          ) {
            NavHost(navController = navController, startDestination = "main") {
              composable("main") {
                MainScreen(
                  currentIndex = currentIndex,
                  displayedText = displayedText,
                  loseDialogOpen = loseDialogOpen,
                  navController = navController,
                  nextFive = nextFive,
                  setCurrentIndex = { currentIndex = it },
                  setLoseDialogOpen = { loseDialogOpen = it },
                  setNextFive = { nextFive = it },
                  validateCurrent = { characterPressed ->
                    if (digits[currentIndex] == characterPressed) {
                      if (displayedText.length == 10) {
                        displayedText = displayedText.substring(1)
                      }
                      displayedText += characterPressed
                      currentIndex++
                    } else {
                      nextFive = digits.substring(currentIndex, currentIndex + 5)
                      loseDialogOpen = true
                      displayedText = "3."
                    }
                  }
                )
              }
              composable("about") { AboutScreen(navController = navController) }
            }
          }
        }
      }
    }
  }
}