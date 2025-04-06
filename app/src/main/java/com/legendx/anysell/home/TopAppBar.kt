package com.legendx.anysell.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.legendx.anysell.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarFun(onOpenDrawer: () -> Unit){
    TopAppBar(
        title = { AppName() },
        navigationIcon = {
            IconButton(onClick = onOpenDrawer) {
                Icon(
                    painter = painterResource(R.drawable.menu),
                    contentDescription = "Menu"
                )
            }

        },
        actions = {
//            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Profile")

            Image(painter = painterResource(R.drawable.profilepic), contentDescription = null
                , contentScale = ContentScale.Crop, modifier = Modifier.size(40.dp).clip(
                    RoundedCornerShape(20.dp)))
            Spacer(modifier = Modifier.width(10.dp))
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())
    )
}

@Composable
fun AppName(){
    Box(
        modifier = Modifier.Companion.fillMaxWidth().padding(start = 16.dp),
        contentAlignment = Alignment.Companion.Center
    ) {
        Text(text = stringResource(id = R.string.app_name), fontWeight = FontWeight.Companion.Bold)
    }
}