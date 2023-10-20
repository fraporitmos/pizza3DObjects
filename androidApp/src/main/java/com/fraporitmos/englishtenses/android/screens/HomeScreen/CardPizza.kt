package com.fraporitmos.englishtenses.android.screens.HomeScreen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fraporitmos.englishtenses.domain.model.Pizza

@Composable
fun Cardpizza(pizza: Pizza, modifier:Modifier){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = modifier
                .background(color = Color(0xFFF3F3F3),)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                AsyncImage(
                    model = pizza.img,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier.fillMaxSize()
                )
            }
            Spacer(modifier = modifier.height(8.dp))
            Column (modifier = modifier.padding(10.dp)){
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ){
                  Text(
                      modifier = modifier.fillMaxWidth(
                            fraction = 0.5f
                      ),
                      text = pizza.name,
                      style = MaterialTheme.typography.titleLarge,
                      fontWeight = FontWeight.Bold,
                      maxLines = 2,
                      overflow = TextOverflow.Ellipsis,
                      color = Color.Black
                  )
                  Spacer(modifier = modifier.height(8.dp))
                  Text(
                      text = "S/ ${pizza.price}",
                      style = MaterialTheme.typography.titleLarge,
                      fontWeight = FontWeight.Bold,
                      maxLines = 3,
                      overflow = TextOverflow.Ellipsis,
                      color = Color.Black
                  )

              }

                Spacer(modifier = modifier.height(8.dp))

                Text(
                    text = pizza.desc,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black

                )
            }

        }
    }
}