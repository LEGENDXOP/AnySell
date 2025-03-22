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
                if (screenName == AuthUtils.Screens.REGISTER.name) {
                    RegisterScreen()
                } else if (screenName == AuthUtils.Screens.LOGIN.name) {
                    LoginScreen()
                } else if (screenName == AuthUtils.Screens.HOME_SCREEN.name) {
                    HomeScreen()
                } else {
                    ForgotPasswordScreen()
                }
            }
        }
    }
}
