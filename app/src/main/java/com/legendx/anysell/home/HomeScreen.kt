package com.legendx.anysell.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.legendx.anysell.auth.AuthUtils
import com.legendx.anysell.utils.Appwrite
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(){
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "Home Screen", modifier = Modifier.clickable{
            coroutineScope.launch {
                Appwrite.logoutAccount()
            }.invokeOnCompletion {
                AuthUtils.switchScreen(context, AuthUtils.Screens.REGISTER)
            }
        })
    }
}