package com.legendx.anysell.auth

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.legendx.anysell.utils.Appwrite
import io.appwrite.exceptions.AppwriteException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun LoginButton(x0: String, onButtonClick: () -> Unit = {}) {
    Button(
        onClick = onButtonClick, modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFf83658)),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text = x0, fontSize = 20.sp)
    }
}

@Composable
fun WelcomeText(text1: String, text2: String) {
    Column(modifier = Modifier) {
        Text(text = text1, fontWeight = FontWeight.ExtraBold, fontSize = 35.sp)
        Text(text = text2, fontWeight = FontWeight.ExtraBold, fontSize = 35.sp)
    }

}

@Composable
fun WelcomeTextField(image: ImageVector, text: String, onTextChange: (String) -> Unit = {}) {
    var textvalue by remember { mutableStateOf("") }
    OutlinedTextField(
        value = textvalue,
        onValueChange = {
            textvalue = it
            onTextChange(it)
        },
        label = { Text(text = text) },
        leadingIcon = { Icon(imageVector = image, contentDescription = null) },
        singleLine = true,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun WelcomeTextFieldPassword(
    image: ImageVector,
    text: String,
    onTextChange: (String) -> Unit = {}
) {
    var password by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.End) {
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                onTextChange(it)
            },
            singleLine = true,
            label = { Text(text = text) },
            leadingIcon = { Icon(imageVector = image, contentDescription = null) },
            trailingIcon = {
                Icon(
                    imageVector = if (visible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = null,
                    modifier = Modifier.clickable(onClick = { visible = !visible })
                )
            },
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable(onClick = {
                AuthUtils.switchScreen(context, AuthUtils.Screens.FORGOT_PASSWORD)
            }),
            color = Color(0xFFf83658)
        )

    }
}


@Composable
fun CustomTextField(
    hint: String,
    icon: ImageVector,
    isPassword: Boolean = false,
    textValue: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.padding(vertical = 20.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                textValue(it)
            },
            placeholder = { Text(hint) },
            singleLine = true,
            leadingIcon = { Icon(icon, contentDescription = null) },
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }
            },
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )
    }
}

@Composable
fun SocialLoginButton(iconRes: Int) {
    IconButton(
        onClick = {},
        modifier = Modifier
            .size(50.dp)
            .background(Color.LightGray, shape = CircleShape)
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null)
    }
}


object AuthUtils {
    enum class Screens {
        LOGIN,
        REGISTER,
        FORGOT_PASSWORD,
        HOME_SCREEN
    }

    fun switchScreen(context: Context, screen: Screens) {
        try {
            val intent = Intent(context, AuthActivity::class.java)
            intent.putExtra("screen", screen.name)
            context.startActivity(intent)
        }
        catch (e: Exception){
            Log.i("AuthUtils", "switchScreen: ${e.message}")

        }

//        (context as Activity).finish() // will think about this later sed.
    }

    fun checkEmailAndPassword(email: String, password: String): Boolean {
        return email.contains("@") && password.length >= 6
    }

    suspend fun isLoggedIn(): Boolean {
        return try {
            val user = withContext(Dispatchers.IO) { Appwrite.account.get() }
            Log.i("Appwrite", "User is logged in: ${user.email}")
            true
        } catch (e: AppwriteException) {
            Log.i("Appwrite", "User is not logged in: ${e.message}")
            false
        } catch (e: Exception) {
            Log.i("Appwrite", "User is not logged in: ${e.message}")
            false
        }
    }


}