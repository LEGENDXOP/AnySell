package com.legendx.anysell.RestScreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.legendx.anysell.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun productDetailsScreen(modifier: Modifier = Modifier) {
    val imageList = listOf(
        R.drawable.groot,
        R.drawable.groot,
        R.drawable.groot,
        R.drawable.groot,
        R.drawable.groot,
        R.drawable.groot,
    )
    var pagerState = rememberPagerState { imageList.size }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "", modifier = Modifier.padding(start = 30.dp)
            )
            Icon(
                painter = painterResource(R.drawable.shoping_cart),
                contentDescription = "", modifier = Modifier.padding(end = 30.dp)
            )

        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                .padding(horizontal = 20.dp)
        ) {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
                modifier = Modifier.fillMaxWidth(),
                pageSpacing = 30.dp
            ) { page ->
                Image(
                    painter = painterResource(imageList[page]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )

            }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "NIke Sneakers", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Vision Alta Men's Shoes Size (All Colours)", fontSize = 13.sp)


            Row() {
                Icon(
                    painter = painterResource(R.drawable.rupee),
                    contentDescription = null,
                    modifier = Modifier.size(23.dp)
                )
                Text(text = "1500", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }



            Text(text = "Product Details", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(
                text =
                    "Perhaps the most iconic sneaker of all-time, this original" +
                            "\"Chicago\"? colorway is the cornerstone to any sneaker" +
                            "collection. Made famous in 1985 by Michael Jordan, the" +
                            "shoe has stood the test of time, becoming the most" +
                            "famous colorway of the Air Jordan 1. This 2015 release saw" +
                            "the", fontWeight = FontWeight.Light,
                fontSize = 13.sp,
                maxLines = 6
            )
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.gotocart), contentDescription = "",
                    modifier = Modifier
                        .clickable(onClick = { })
                )
                Image(
                    painter = painterResource(R.drawable.buynow), contentDescription = "",
                    modifier = Modifier
                        .size(width = 240.dp, height = 66.dp)
                        .clickable(onClick = { })
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                colors = CardDefaults.cardColors(Color(0xFFffccd5)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    text = "Delivery in",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 30.dp, top = 10.dp)
                )
                Text(
                    text = "1 Within Hour",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 30.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(5.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(R.drawable.outlined_eye),
                                contentDescription = ""
                            )

                        }
                        Text(text = "View Similar", fontSize = 12.sp)


                    }

                }
                Spacer(modifier = Modifier.width(7.dp))
                Card(
                    shape = RoundedCornerShape(7.dp),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(5.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { }) {
                            Icon(
                                painter = painterResource(R.drawable.compare),
                                contentDescription = ""
                            )

                        }
                        Text(text = "Add to Compare", fontSize = 12.sp)


                    }

                }


            }

        }


    }

}