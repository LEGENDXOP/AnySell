package com.legendx.anysell.auth

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.legendx.anysell.utils.Appwrite
import kotlinx.coroutines.launch


@Composable
fun RegisterScreen() {
    val context = LocalContext.current
    val registerViewModel = viewModel { AuthViewModel() }
    val emailText by registerViewModel.email.collectAsStateWithLifecycle()
    val passwordText by registerViewModel.password.collectAsStateWithLifecycle()
    val confirmPasswordText by registerViewModel.confirmPassword.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 40.dp, end = 40.dp),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Create an",
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "account",
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            CustomTextField("Email", Icons.Default.Person){
                registerViewModel.changeEmail(it)
            }
            CustomTextField("Password", Icons.Default.Lock, isPassword = true){
                registerViewModel.changePassword(it)
            }
            CustomTextField("Confirm Password", Icons.Default.Lock, isPassword = true){
                registerViewModel.changeConfirmPassword(it)
            }
            Text(
                text = "By clicking the Register button, you agree to our terms & conditions.",
                fontSize = 12.sp,
                color = Color.Gray,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 30.dp)
            )
            Button(
                onClick = {
                    if (AuthUtils.checkEmailAndPassword(emailText, passwordText).not()) {
                        return@Button
                    }
                    if (passwordText != confirmPasswordText) {
                        return@Button
                    }
                    coroutineScope.launch {
                        Appwrite.registerAccount(emailText, passwordText)
                    }.invokeOnCompletion {
                        println("User Registered")
                        AuthUtils.switchScreen(context, AuthUtils.Screens.HOME_SCREEN)
                    }
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFE91E63)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text = "Create Account", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "- OR Continue with -", fontSize = 12.sp, color = Color.Gray)
            Spacer(Modifier.height(12.dp))
            Text(text = "I have already an account",
                modifier = Modifier.clickable {
                    AuthUtils.switchScreen(context, AuthUtils.Screens.LOGIN)
                })
        }
    }
}
