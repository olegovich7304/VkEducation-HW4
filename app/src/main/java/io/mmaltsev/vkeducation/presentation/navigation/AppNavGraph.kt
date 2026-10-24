package io.mmaltsev.vkeducation.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.mmaltsev.vkeducation.presentation.appdetails.AppDetailsScreen
import io.mmaltsev.vkeducation.presentation.applist.AppCatalogScreen

object Routes {
    const val APP_LIST = "app_list"
    const val APP_DETAILS = "app_details"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.APP_LIST,
    ) {
        // Экран списка приложений
        composable(Routes.APP_LIST) {
            AppCatalogScreen(
                // Клик по приложению из списка -> открыть карточку приложения
                onAppClick = {
                    navController.navigate(Routes.APP_DETAILS)
                },
            )
        }

        // Экран карточки приложения (из практической части)
        composable(Routes.APP_DETAILS) {
            AppDetailsScreen(
                // Стрелка «Назад» в тулбаре карточки
                onBackClick = {
                    navController.popBackStack()
                },
                // Клик по приложению из «Витрины» -> вернуться на список приложений
                onShowcaseAppClick = {
                    navController.popBackStack(Routes.APP_LIST, false)
                },
            )
        }
    }
}