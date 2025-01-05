package com.example.areyouhot

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeActivity() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(10.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier.fillMaxWidth(0.16f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "역삼동")
                    Icon(
                        modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "dropdown"
                    )
                }
                Row() {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sample),
                            contentDescription = "sample",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sample),
                            contentDescription = "sample",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.sample),
                            contentDescription = "sample",
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeActivityPreview() {
    HomeActivity()
}