package com.legendx.anysell.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.legendx.anysell.utils.Appwrite
import io.appwrite.exceptions.AppwriteException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val authViewmodel = viewModel { AuthViewModel() }
    val emailText by authViewmodel.email.collectAsStateWithLifecycle()
    val passwordText by authViewmodel.password.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, start = 20.dp, end = 20.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            WelcomeText("Welcome", "Back!")
        }
        Box(modifier = Modifier.weight(.7f)) {
            WelcomeTextField(Icons.Default.AccountCircle, "Username or Email") {
                authViewmodel.changeEmail(it)
            }
        }
        Box(modifier = Modifier.weight(1.5f)) {
            WelcomeTextFieldPassword(Icons.Default.Lock, "Password") {
                authViewmodel.changePassword(it)
            }
        }
        Box(modifier = Modifier.weight(3.8f)) {
            LoginButton("Login") {
//                if (AuthUtils.checkEmailAndPassword(emailText, passwordText).not()) {
//                    Toast.makeText(context,"Invalid Email or Password",Toast.LENGTH_SHORT).show()
//                }
//                coroutineScope.launch {
//                    Appwrite.loginAccount(emailText, passwordText)
//                }.invokeOnCompletion {
//                    println("User Logged In")
//                    AuthUtils.switchScreen(context, AuthUtils.Screens.HOME_SCREEN)
//                }
                if (!AuthUtils.checkEmailAndPassword(emailText, passwordText)) {
                    Toast.makeText(context, "Invalid Email or Password", Toast.LENGTH_SHORT).show()
                    return@LoginButton // Exit early if credentials are not valid
                }

                coroutineScope.launch {
                    try {
                        // Switch to the background thread for network operations
                        withContext(Dispatchers.IO) {
                            Appwrite.loginAccount(emailText, passwordText)
                        }
                        // If successful, switch to the main thread for UI updates.
                        withContext(Dispatchers.Main) {
                            println("User Logged In")
                            AuthUtils.switchScreen(context, AuthUtils.Screens.HOME_SCREEN)
                        }
                    } catch (e: Exception) {
                        // Handle any exception that occurred during login
                        withContext(Dispatchers.Main) {
                            when (e) {
//                                is Appwrite.AppwriteException ->
                                is AppwriteException ->
                                    {
                                    Toast.makeText(context, "Appwrite Error: ${e.message}", Toast.LENGTH_LONG).show()
                                }
                                is java.net.UnknownHostException -> {
                                    Toast.makeText(context, "Network Error: Unable to connect to the server", Toast.LENGTH_LONG).show()
                                }
                                else -> {
                                    Toast.makeText(context, "Login failed: ${e.message}", Toast.LENGTH_LONG).show()
                                    println("Error during login: ${e.stackTraceToString()}")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

