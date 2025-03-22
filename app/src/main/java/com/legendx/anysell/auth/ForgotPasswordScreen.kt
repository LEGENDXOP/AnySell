package com.legendx.anysell.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ForgotPasswordScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Forgot",
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Password?",
                fontSize = 44.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        var textvalue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = textvalue,
            onValueChange = { textvalue = it },
            label = { Text(text = "Enter your email address") },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        Text(
            text = "We will send you a message to set or reset your new password.",
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 30.dp)
        )
        Button(
            onClick = { /* Handle Register */ },
            colors = ButtonDefaults.buttonColors(Color(0xFFE91E63)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Submit", fontSize = 16.sp, color = Color.White)
        }

    }

}