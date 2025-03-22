package com.legendx.anysell

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.legendx.anysell.auth.AuthActivity
import com.legendx.anysell.auth.AuthUtils
import com.legendx.anysell.ui.theme.AnySellTheme
import com.legendx.anysell.utils.Appwrite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Appwrite.init(applicationContext)
        val intent = Intent(this, AuthActivity::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            if (AuthUtils.isLoggedIn()){
                intent.putExtra("screen", AuthUtils.Screens.HOME_SCREEN.name)
            }else{
                intent.putExtra("screen", AuthUtils.Screens.REGISTER.name)
            }
            withContext(Dispatchers.Main){
                startActivity(intent)
                finish()
            }
        }
        enableEdgeToEdge()
        setContent {
            AnySellTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding.calculateTopPadding()
                }
            }
        }
    }
}
