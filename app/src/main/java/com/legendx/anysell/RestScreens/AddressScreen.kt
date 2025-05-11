package com.legendx.anysell.RestScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.legendx.anysell.R
import com.legendx.anysell.data.ProductData
import com.legendx.anysell.data.productList

@Composable
fun addressScreen(modifier: Modifier = Modifier) {
    var address = "216 St Paul's Rd, London N1 2LL, UK\n" +
            "Contact: +44-784232"
    Column(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "",
                modifier = Modifier.padding(start = 30.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Checkout", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(R.drawable.location_icon), contentDescription = "")
                Text(text = "Delivery Address", fontWeight = FontWeight.Bold)

            }
            Spacer(modifier = Modifier.height(20.dp))
            //card row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .weight(3f)
                        .height(100.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(5.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {

                    Row {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = "Address :",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                            )
                            Text(text = address, letterSpacing = 0.2.sp, fontSize = 12.sp)
                        }
                        Icon(
                            painter = painterResource(R.drawable.edit_outlined_icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(25.dp)
                                .clickable(onClick = { })
                        )

                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(100.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(10.dp),
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(R.drawable.add_circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }

                    }
                }

            }
            Text(
                text = "Shoping List",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
            )
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(productList) { product ->
                    ProductCardAdressFunction(product)
                    Spacer(modifier = Modifier.height(20.dp))
                }

            }

        }
    }

}

@Composable
fun ProductCardAdressFunction(product: ProductData) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://media.istockphoto.com/id/2152947512/photo/beautiful-blonde-woman-in-white-casual-dress-enjoys-famous-tegallalang-rice-terrace-view-in.jpg?s=2048x2048&w=is&k=20&c=jjf4jVaNa4VPRA54FZPTKWGQy8syjbz0kCxvODdorec=",

                    contentDescription = product.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(180.dp)
                )
            }

            Column(modifier = Modifier.weight(3f)) {
                Text(text = product.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "⭐ ${product.ratings}",
                    fontSize = 12.sp,
                    color = Color(0xFFFFC107)
                )
                Box(
                    modifier = Modifier
                        .border(
                            BorderStroke(1.dp, Color.LightGray),
                            RoundedCornerShape(5.dp)
                        )
                        .padding(10.dp), contentAlignment = Alignment.BottomEnd
                ) {
                    Row {
                        Icon(
                            painter = painterResource(R.drawable.rupee), contentDescription = "",
                            modifier = Modifier.padding(end = 10.dp)
                        )
                        Text(
                            text = product.price.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }

                }


            }
        }
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Total Order (1) :", fontWeight = FontWeight.SemiBold)
            Row {
                Icon(
                    painter = painterResource(R.drawable.rupee), contentDescription = "",
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = product.price.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }


        }
    }
}