package com.legendx.anysell.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.legendx.anysell.auth.ui.theme.AnySellTheme
import com.legendx.anysell.home.HomeScreen
import com.legendx.anysell.utils.Appwrite

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Appwrite.init(applicationContext)
        val screenName = intent.getStringExtra("screen")
        enableEdgeToEdge()
        setContent {
            AnySellTheme {
                when(screenName){
                    AuthUtils.Screens.REGISTER.name -> RegisterScreen()
                    AuthUtils.Screens.LOGIN.name -> LoginScreen()
                    AuthUtils.Screens.FORGOT_PASSWORD.name -> ForgotPasswordScreen()
                    AuthUtils.Screens.HOME_SCREEN.name -> HomeScreen()
                }
            }
        }
    }
}
