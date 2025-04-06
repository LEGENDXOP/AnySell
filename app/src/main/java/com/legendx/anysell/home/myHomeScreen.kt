package com.legendx.anysell.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import coil.compose.AsyncImage
import com.legendx.anysell.data.productList
import com.legendx.anysell.data.ProductData
import com.legendx.anysell.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBarFun(onOpenDrawer = {
                scope.launch {
                    drawerState.apply {
                        if (isClosed) open() else close()
                    }
                }
            })
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                    end = innerPadding.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            searchBarFun()
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                items(productList) { product ->
                    ProductCard(product)
                }
            }

        }
    }

}

@Composable
fun ProductCard(product: ProductData) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            AsyncImage(
                model = "https://media.istockphoto.com/id/2152947512/photo/beautiful-blonde-woman-in-white-casual-dress-enjoys-famous-tegallalang-rice-terrace-view-in.jpg?s=2048x2048&w=is&k=20&c=jjf4jVaNa4VPRA54FZPTKWGQy8syjbz0kCxvODdorec=",
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = product.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "${product.shortDescription}",
                    fontSize = 12.sp
                )
                Text(
                    text = "${product.longDescription}",
                    fontSize = 12.sp
                )

                Text(
                    text = "₹${product.price}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "⭐ ${product.ratings}",
                    fontSize = 12.sp,
                    color = Color(0xFFFFC107)
                )

            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBarFun(modifier: Modifier = Modifier) {
    //sort or filter bhi esi me hain
    var expended by remember { mutableStateOf(false) }
    var myQuery by remember { mutableStateOf("") }
    var myActive by remember { mutableStateOf(false) }
    var isExpended by remember { mutableStateOf(false) }
    var OptoinList = listOf("option 1", "option 2", "option 3") // dummy list
    var selectected by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, bottom = 10.dp, start = 8.dp, end = 8.dp),
            query = myQuery,
            onQueryChange = { myQuery = it },
            active = myActive,
            onSearch = {
                if (myQuery.isEmpty()) {
                    myActive = false

                } else {
                    // search history to be added in the search histroy list
                }
                myActive = false
//                        searchResult = result(it)
                myQuery = ""
            },
            onActiveChange = { myActive = it },
            placeholder = { Text(text = "Search any product ...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = " Search Icon"
                )
            },
            trailingIcon = {
                if (myActive) {
                    IconButton(onClick = {
                        if (myQuery.isNotEmpty()) {
                            myQuery = ""
                        } else {
                            myActive = false
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Search Bar"
                        )
                    }
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = SearchBarDefaults.colors(
                containerColor = Color.White
            )
        ) {
            //search result yha dikhenge
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "All Featured", fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
            Row {
                Button(
                    modifier = Modifier.size(width = 80.dp, height = 40.dp),
                    onClick = { isExpended = true },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(6.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {

                    Text("Sort", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        painter = painterResource(R.drawable.sort),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    DropdownMenu(
                        expanded = isExpended,
                        onDismissRequest = { isExpended = false }) {
                        OptoinList.forEach {
                            DropdownMenuItem(
                                text = { Text(text = it) },
                                onClick = {
                                    selectected = it
                                    isExpended = false
                                })
                        }
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier.size(width = 80.dp, height = 40.dp),
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(6.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Filter", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Icon(painter = painterResource(R.drawable.filter), contentDescription = null)
                }


            }
        }
    }

}