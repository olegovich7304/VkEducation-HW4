package io.mmaltsev.vkeducation.presentation.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppCatalogScreen(
    onAppClick: (AppItem) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F5F7))
            .safeDrawingPadding()
    ) {
        AppToolbar()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Популярные приложения",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF202124)
                )

                Spacer(modifier = Modifier.height(4.dp))
            }

            items(catalogApps) { app ->
                AppCard(
                    app = app,
                    onClick = { onAppClick(app) },
                )
            }
        }
    }
}

@Composable
fun AppToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF6750A4))
            .padding(horizontal = 20.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6750A4)
            )
        }

        Column(
            modifier = Modifier.padding(start = 14.dp)
        ) {
            Text(
                text = "App Catalog",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Каталог приложений",
                fontSize = 13.sp,
                color = Color.White
            )
        }
    }
}