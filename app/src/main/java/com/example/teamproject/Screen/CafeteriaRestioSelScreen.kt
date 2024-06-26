package com.example.teamproject.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.teamproject.R
import com.example.teamproject.ViewModel.LocalNavGraphViewModelStoreOwner
import com.example.teamproject.ViewModel.UserViewModel
import com.example.teamproject.navigation.Routes

@Composable
fun CafeteriaRestioSelScreen(
    navController: NavHostController,
    userViewModel: UserViewModel = viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // 상단 바 구현
            TopAppBar(
                onBackIconClick = { navController.popBackStack() },
                title = "학식 / 레스티오",
                titleColor = Color.Black,
                onRightIconClick = { navController.navigate(Routes.MyPageMainScreen.route) },
                rightIconImgId = R.drawable.profile
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.konkuk),
                    contentDescription = null,
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "${userViewModel.user.name} 학우님 안녕하세요", /* todo 아이디 연결 */
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard_medium))
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { navController.navigate(Routes.RestaurantStart.route) },
                        modifier = Modifier
                            .height(250.dp)
                            .weight(1f)
                            .background(Color(0xFFF5E6CA), shape = RoundedCornerShape(16.dp))
                            .border(
                                1.dp,
                                colorResource(id = R.color.gray_b3b3b3),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.eat),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(bottom = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(30.dp))
                            Text(
                                text = "학식",
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard_medium))
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate(Routes.RestioStart.route) },
                        modifier = Modifier
                            .height(250.dp)
                            .weight(1f)
                            .background(Color(0xFFD6E8E8), shape = RoundedCornerShape(16.dp))
                            .border(
                                1.dp,
                                colorResource(id = R.color.gray_b3b3b3),
                                shape = RoundedCornerShape(16.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.restio),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(120.dp)
                                    .padding(bottom = 8.dp)
                            )
                            Spacer(modifier = Modifier.height(30.dp))
                            Text(
                                text = "레스티오",
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard_medium))
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(56.dp))
            }
        }
    }
}

