package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.presentation.applist.AppCard
import io.mmaltsev.vkeducation.presentation.applist.AppItem
import io.mmaltsev.vkeducation.presentation.applist.showcaseApps
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

private const val APPS_PER_PAGE = 3

@Composable
fun Showcase(
    apps: List<AppItem>,
    onAppClick: (AppItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    // 9 приложений -> 3 страницы по 3 приложения
    val pages = apps.chunked(APPS_PER_PAGE)
    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(modifier) {
        Text(
            text = stringResource(R.string.app_details_showcase),
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(Modifier.height(8.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 4.dp),
            pageSpacing = 12.dp,
            verticalAlignment = Alignment.Top,
        ) { pageIndex ->
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                pages[pageIndex].forEach { app ->
                    AppCard(
                        app = app,
                        onClick = { onAppClick(app) },
                    )
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        // Индикатор страниц (точки)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            repeat(pages.size) { index ->
                val selected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (selected) 10.dp else 8.dp)
                        .clip(CircleShape)
                        .background(
                            if (selected) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outlineVariant
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VkEducationTheme {
        Showcase(
            apps = showcaseApps,
            onAppClick = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}