package com.example.quizit.pages

import android.util.DisplayMetrics
import android.view.Display
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizit.R
import com.example.quizit.ui.theme.Righteous

@Composable
fun WelcomePage(
    navController : NavController
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    Box(
        modifier = Modifier
            .height(screenHeight.dp)
            .width(screenWidth.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFEAD1), Color(0xFFFFE7CA)),
                    startY = (screenHeight.toFloat()) / 1.2f,
                    endY = screenHeight.toFloat(),
                )
            )
    ) {
        Box(modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFDBF03), Color(0xFFFF6F00), Color(0xFFFF5900)),
                    start = Offset.Zero,
                    end = Offset.Infinite,
                ),
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
            )
            .fillMaxWidth()
            .height((screenHeight / 5).dp)

        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = (screenHeight / 12).dp),
            contentAlignment = Alignment.TopCenter
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 5.dp, end = 5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.boy_thinking),
                    contentDescription = null,
                    modifier = Modifier
                        .width(320.dp)
                        .height((screenHeight / 2.5).dp)
                )
                Text(
                    text = "Bilgini Test Et",
                    style = TextStyle(
                        fontSize = 39.sp,
                        lineHeight = 56.92.sp,
                        fontFamily = Righteous,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFF6B00),
                        textAlign = TextAlign.Center,
                        letterSpacing = 2.21.sp,
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Merhaba, Quizit’e hoş geldin! \nEğlenceli ve öğretici bir deneyim sunmak için buradayız. Hazır mısın? Soruları yanıtlamak ve bilgini test etmek için hemen başlayalım!",
                    style = TextStyle(
                        fontSize = 17.sp * (screenWidth.dp / 360.dp),
                        lineHeight = 29.sp,
                        fontFamily = Righteous,
                        fontWeight = FontWeight(400),
                        color = Color(0xB2000000),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.48.sp,
                    )
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = {
                        navController.navigate(route = "QuizPage")
                    },
                    modifier = Modifier
                        .padding(start = 29.dp, end = 29.dp)
                        .fillMaxWidth()
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0xFF000000),
                            ambientColor = Color(0xFF000000)
                        )
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color(0xFFFC941B), Color(0xFFF0741A)),
                                startX = 0f,
                                endX = 600f
                            )
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(0.dp)
                ) {
                    Text(
                        text = "Hadi Başlayalım!",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 28.28.sp,
                            fontFamily = Righteous,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            letterSpacing = 1.9.sp,
                        ),
                        modifier = Modifier.padding(3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Unutma! Soruları cevaplaman için 3 dakikan var. Hazırsan yukarıdaki butona tıkla.",
                    style = TextStyle(
                        fontSize = 13.sp,
                        lineHeight = 20.21.sp,
                        fontFamily = Righteous,
                        fontWeight = FontWeight(400),
                        color = Color(0x99000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 14.dp)
                )
            }

        }

    }
}