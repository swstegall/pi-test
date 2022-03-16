package me.stegall.pitest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController) {
  val uriHandler = LocalUriHandler.current

  TopAppBar(
    title = { Text(text = "About Pi Test") },
    navigationIcon = {
      IconButton(onClick = {
        navController.navigate("main")
      }) {
        Icon(Icons.Filled.ArrowBack, "Return to Pi Test")
      }
    }
  )
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      Text(text = "Created by Sam Stegall", fontSize = 30.sp)
    }
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp),
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      ClickableText(
        text = AnnotatedString("stegall.me"),
        style = TextStyle(fontSize = 30.sp, color = Color(0xff64B5F6)),
        onClick = { uriHandler.openUri("https://stegall.me") })
    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
      ClickableText(
        text = AnnotatedString("Buy Me a Coffee"),
        style = TextStyle(fontSize = 30.sp, color = Color(0xff64B5F6)),
        onClick = { uriHandler.openUri("https://www.buymeacoffee.com/swstegall") })
    }
  }
}
