package com.legendx.anysell.RestScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.legendx.anysell.R

@Composable
fun ShopingBagScreen(modifier: Modifier = Modifier) {
    var date by remember { mutableStateOf(" 10  May 2025") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 60.dp, start = 30.dp, end = 30.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
            )
            Text(text = "Shoping Bag", fontWeight = FontWeight.Bold)
            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )


        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp),
                shape = RoundedCornerShape(7.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profilepic),
                    contentDescription = "",
                    contentScale = ContentScale.Crop, modifier = Modifier
                )


            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.height(200.dp)) {
                Text("Women's casual wear", fontWeight = FontWeight.Bold)
                Text(
                    text = "Checked Single-Brested blazer",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(60.dp))
                Row {
                    Text(text = "Delivery by", fontSize = 12.sp, fontWeight = FontWeight.Light)

                    Text(text = "$date", fontWeight = FontWeight.Bold)

                }
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.coupon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 5.dp)
                )
                Text(text = "Apply Coupons")
            }
            Text(
                text = "Select",
                color = Color(0xFFE91E63),
                modifier = Modifier.clickable(onClick = { })
            )

        }
        Spacer(modifier = Modifier.height(40.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Oder Payment Details", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Oder Amount", fontWeight = FontWeight.Light)
                Row {
                    Icon(painter = painterResource(R.drawable.rupee), contentDescription = "")
                    Text(text = "7,000.00", fontWeight = FontWeight.Bold)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(text = "Convenience", fontWeight = FontWeight.Light)
                    Text(
                        text = "Know more",
                        fontSize = 15.sp,
                        color = Color(0xFFE91E63),
                        modifier = Modifier
                            .clickable(onClick = { })
                            .padding(start = 5.dp)
                    )
                }
                Text(
                    text = "Apply Coupon",
                    color = Color(0xFFE91E63),
                    modifier = Modifier.clickable(onClick = { })
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Delivery Fee", fontWeight = FontWeight.Light)
                Text(text = "Free", color = Color(0xFFE91E63))
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Order Total")
            Row {
                Icon(painter = painterResource(R.drawable.rupee), contentDescription = "")
                Text(text = "7,000.00", fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.Gray)
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row {
                    Icon(painter = painterResource(R.drawable.rupee), contentDescription = "")
                    Text(text = "7,000.00", fontWeight = FontWeight.Bold)
                }
                Text(text = "View Details", color = Color(0xFFE91E63))
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63)),
                modifier = Modifier
                    .weight(1.5f)
                    .height(50.dp)
            ) {
                Text(text = "Proceed to Payment")

            }

        }

    }
}