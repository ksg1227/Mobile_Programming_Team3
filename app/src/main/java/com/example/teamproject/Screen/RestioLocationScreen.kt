package com.example.teamproject.Screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.teamproject.Item.LocationItem
import com.example.teamproject.R
import com.example.teamproject.navigation.Routes
import kotlinx.coroutines.launch

@Composable
fun RestioTabPager(pagerState: PagerState, tabs: List<String>, navController: NavHostController) {

    val coroutineScope = rememberCoroutineScope() // 코루틴 스코프 생성
    val location = Restio_Location_init()

    Column {
        // 상단바
        TopAppBar(
            onBackIconClick = { navController.popBackStack() },
            title = "레스티오",
            titleColor = Color.Black,
            onRightIconClick = { navController.navigate(Routes.MyPageMainScreen.route) }, // 추후 마이페이지로 이동 가능하도록 구현
            rightIconImgId = R.drawable.profile
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(), // 화면 전체 너비
            color = Color.LightGray, // 테두리 색상
            thickness = 1.dp // 테두리 두께
        )
        // 탭 구현
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    color = colorResource(id = R.color.green_066b3f), // 인디케이터 색상 변경
                )
            },
            divider = {}, // 빈 컴포저블을 지정하여 경계선 제거
            containerColor = Color.White, // 배경색 설정
            contentColor = Color.Black
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            fontFamily = FontFamily(Font(R.font.pretendard_semibold))
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier
                        .width(200.dp)  // 탭의 가로 크기
                        .height(50.dp), // 탭의 세로 크기
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(), // 화면 전체 너비
            color = Color.LightGray, // 테두리 색상
            thickness = 1.dp // 테두리 두께
        )

        // 뷰페이저 구현
        HorizontalPager(
            state = pagerState
        ) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)

            ) {
                // 페이지별 컨텐츠
                when (page) {
                    1 -> MapScreen(navController = navController, location)
                    0 -> ListScreen(navController = navController, location, R.color.green_0A1009)

                }
            }
        }
    }
}

fun Restio_Location_init(): List<LocationItem> {
    val location: List<LocationItem> = listOf(
        LocationItem(
            "레스티오 동물생명과학관",
            "서울 광진구 능동로 120 1층(화양동)",
            37.5403664,
            127.0743614,
            Routes.AnimalLifeRestioScreen.route,
            "월~금 09:00 ~ 18:00"
        ),
        LocationItem(
            "레스티오 상허기념도서관",
            "서울 광진구 능동로 120 3층(화양동)",
            37.5419226,
            127.0737408,
            Routes.LibraryRestioScreen.route,
            "월~금 09:00 ~ 18:00"
        ),
        LocationItem(
            "레스티오 경영관",
            "서울 광진구 능동로 120 1층(화양동)",
            37.5442615,
            127.0760717,
            Routes.ManagementRestioScreen.route,
            "월~금 08:30 ~ 18:00"
        ),
        LocationItem(
            "레스티오 공학관",
            "서울 광진구 능동로 120 건국대학교 공학관 1층(화양동)",
            37.541635,
            127.0787904,
            Routes.EngineeringRestioScreen.route,
            "월~금 08:30 ~ 18:00"
        ),
        LocationItem(
            "레스티오 산학협동관",
            "서울 광진구 능동로 120 1층(화양동)",
            37.5396663,
            127.0732309,
            Routes.IndustryRestioScreen.route,
            "월~금 08:30 ~ 19:00"
        )
    )
    return location
}

@Composable
fun RestioLocationScreen(navController: NavHostController) {
    val tabs = listOf("리스트로 보기", "지도로 보기")
    val pagerState = rememberPagerState {
        tabs.size
    }

    Column {
        RestioTabPager(
            pagerState = pagerState,
            tabs = tabs,
            navController = navController
        )
    }
}