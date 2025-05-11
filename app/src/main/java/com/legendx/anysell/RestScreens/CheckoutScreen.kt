package com.legendx.anysell.RestScreens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.legendx.anysell.R
import com.legendx.anysell.data.checkoutCardsData
import com.legendx.anysell.data.checkoutList

@Composable
fun checkoutScreen(modifier: Modifier = Modifier.Companion) {
    //order values
    var price: Int = 7000;
    var shiping: Int = 30;
    var total: Int = price + shiping;
    var selectedCardIndex by remember { mutableStateOf(-1) }
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
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Checkout", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Order", fontWeight = FontWeight.Light, fontSize = 20.sp)
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.rupee),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                    Text("$price", fontWeight = FontWeight.Light, fontSize = 20.sp)
                }


            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Shiping", fontWeight = FontWeight.Light, fontSize = 20.sp)
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.rupee),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                    Text("$shiping", fontWeight = FontWeight.Light, fontSize = 20.sp)
                }


            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", fontSize = 20.sp)
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.rupee),
                        contentDescription = null,
                        modifier = Modifier.size(23.dp)
                    )
                    Text("$total", fontSize = 20.sp)
                }


            }
            HorizontalDivider(thickness = 1.dp, color = Color.Gray)

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text("Payment", fontSize = 20.sp)
            Text("Payment", fontSize = 20.sp)
            checkoutList.forEachIndexed { index, cardData ->
                checkOutCards(
                    data = cardData,
                    isSelected = selectedCardIndex == index, // Pass true if this card's index matches the selected index
                    onCardClick = {
                        selectedCardIndex =
                            index // Update the selected index when this card is clicked
                    }
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFE91E63)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text("Continue", fontWeight = FontWeight.Bold, fontSize = 25.sp)

            }

        }

    }

}

@Composable
fun checkOutCards(data: checkoutCardsData, isSelected: Boolean, onCardClick: () -> Unit) {
    var selected: Boolean by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable(
                onClick = onCardClick
            ),
        shape = RoundedCornerShape(7.dp),
        border = if (selected) BorderStroke(2.dp, Color(0xFFE91E63)) else null
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(data.methodImage),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
            Text(text = data.cardNumber.toString())

        }
    }


}