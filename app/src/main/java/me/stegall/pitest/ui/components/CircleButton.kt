package me.stegall.pitest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.stegall.pitest.ui.theme.Orange700

@Composable
fun CircleButton(
  text: String,
  onClick: () -> Unit,
) {
  OutlinedButton(
    onClick = onClick,
    modifier = Modifier.size(75.dp),
    shape = CircleShape,
    border = BorderStroke(1.dp, Orange700),
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
  ) {
    Text(text = text, fontSize = 25.sp)
  }
}

@Preview
@Composable
fun CircleButtonPreview() {
  CircleButton(text = "0", onClick = {})
}