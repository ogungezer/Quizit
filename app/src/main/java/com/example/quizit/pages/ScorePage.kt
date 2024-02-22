package com.example.quizit.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizit.R
import com.example.quizit.ui.theme.Righteous

@Composable
fun ScorePage(
    score : Int,
    totalQuestionCount : Int,
    answeredCorrectQuestionCount : Int,
    answeredFalseQuestionCount : Int,
    navController: NavController
) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFDDFBB)){
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter){
            Image(painter = painterResource(id = R.drawable.top_border), contentDescription = "")
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 125.dp)
                .padding(horizontal = 18.dp)
        ) {
            Text(
                text = "Tebrikler!",
                style = TextStyle(
                    fontSize = 40.sp,
                    color = Color(0xFFFF6B00),
                    fontWeight = FontWeight(400),
                    fontFamily = Righteous,
                    textAlign = TextAlign.Start,
                    lineHeight = 37.38.sp,
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Quizi Tamamladın.",
                style = TextStyle(
                    fontSize = 34.sp,
                    color = Color(0xB2000000),
                    fontWeight = FontWeight(400),
                    fontFamily = Righteous,
                    textAlign = TextAlign.Start,
                    lineHeight = 37.38.sp,
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterHorizontally)
                    .border(3.dp, color = Color(0xC4FF8C00), shape = RoundedCornerShape(12.dp))
                    .fillMaxWidth()
                    .background(color = Color(0x8AFFAA01), shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center,
            ){
                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)){
                    Text(
                        text = "$score",
                        style = TextStyle(
                            fontSize = 60.sp,
                            color = Color(0xFFFF9900),
                            fontWeight = FontWeight.Bold,
                            fontFamily = Righteous,
                            textAlign = TextAlign.Center,
                            lineHeight = 37.38.sp,
                        )
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Puan",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color(0xB2000000),
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Righteous,
                            textAlign = TextAlign.Center,
                            lineHeight = 37.38.sp,
                        )
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = putEmoji(score = score),
                        contentDescription = "Tebrik Emojisi",
                        alignment = Alignment.TopCenter,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(120.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Soru Sayısı: $totalQuestionCount", 
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color(0xB2000000),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Righteous,
                    textAlign = TextAlign.Center,
                    lineHeight = 37.38.sp,
                    letterSpacing = 4.sp
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Doğru Cevap: $answeredCorrectQuestionCount",
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color(0xB2000000),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Righteous,
                    textAlign = TextAlign.Center,
                    lineHeight = 37.38.sp,
                    letterSpacing = 4.sp
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Yanlış Cevap: $answeredFalseQuestionCount",
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color(0xB2000000),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Righteous,
                    textAlign = TextAlign.Center,
                    lineHeight = 37.38.sp,
                    letterSpacing = 4.sp
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.padding(bottom = 25.dp, start = 10.dp, end = 10.dp).fillMaxWidth()){
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()){
                Button(
                    onClick = { navController.navigate("QuizPage") },
                    modifier = Modifier.weight(1f),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B00), contentColor = Color(0xFFFFFFFF))

                ) {
                    Text(
                        text = "Tekrar Oyna",
                        style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.88.sp,
                        fontFamily = Righteous,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                        )
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                OutlinedButton(
                    onClick = { navController.navigate("WelcomePage") },
                    modifier = Modifier.weight(1f),
                    elevation = ButtonDefaults.buttonElevation(4.dp),
                    border = BorderStroke(2.dp, color = Color(0xFFFF6B00)),
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF), contentColor = Color(0xFFFF6B00))
                ) {
                    Text(
                        text = "Ana Menü",
                        style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.88.sp,
                        fontFamily = Righteous,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFF6B00),
                        textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun putEmoji(score: Int) : Painter {
    val emoji = when {
        score >= 70 -> painterResource(id = R.drawable.cong)
        score > 50 -> painterResource(id = R.drawable.smile)
        score == 50 -> painterResource(id = R.drawable.expressionless)
        score > 20 -> painterResource(id = R.drawable.susp)
        else -> painterResource(id = R.drawable.ohno)
    }
    return emoji
}

