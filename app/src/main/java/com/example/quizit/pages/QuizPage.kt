package com.example.quizit.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.quizit.R
import com.example.quizit.data.Questions.questions
import com.example.quizit.ui.theme.Righteous
import kotlinx.coroutines.delay



@SuppressLint("InvalidColorHexValue")
@Composable
fun QuizPage(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    var index by remember { mutableIntStateOf(0) }

    var currentProgress by remember { mutableStateOf(0f)}
    var isStarted by remember { mutableStateOf(true)}

    val questionList = questions[index].question
    val answerList = questions[index].answers
    val correctAnswer = questions[index].correctAnswer
    val questionCount = questions.size

    var score by remember { mutableIntStateOf(0) }
    var userFalseAnswerCount by remember { mutableIntStateOf(0)}
    var userCorrectAnswerCount by remember { mutableIntStateOf(0)}

    val buttonColorList = remember { // oyun başladığında her bir şık default renk olan turuncu rengini alacağı için renk listesine turuncu atandı her şık için.
        mutableStateListOf<MutableList<Color>>().apply {
            for (i in questions.indices) {
                val colors = mutableStateListOf<Color>()
                for (k in answerList.indices) {
                    colors.add(Color(0xFFF0741A))
                }
                add(colors)
            }
        }
    }

    val buttonStateList = remember { //şıkların tıklanabilirliğini tutan liste oluşturuldu.
        mutableStateListOf<Boolean>().apply{
            for(i in questions.indices){
                add(false)
            }
        }
    }


    suspend fun loadProgress(updateProgress : (Float) -> Unit){ // oyun süresi 3 dakika olarak ayarlandı.
         for (i in 0..180){
             updateProgress(i.toFloat() / 180)
             delay(1000)
         }
    }



    LaunchedEffect(key1 = isStarted){//oyun başlangıç durumuna göre bir CoroutineScope tetiklenecek
        if(isStarted){ //oyun başladıysa süre akmaya başlayacak.
            loadProgress {progress ->
                currentProgress = progress
            }
            if(currentProgress == 1f){ //süre bittiği zaman sonuç ekranına yönlendirilecek ve buraya oyunla alakalı skor bilgileri aktarılacak.
                navController.navigate("ScorePage/${score}/${questionCount}/${userCorrectAnswerCount}/${userFalseAnswerCount}")
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFFF7700), Color(0xFFFC7600)),
                        startY = 0f,
                        endY = screenHeight.toFloat(),
                    )
                )
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            LinearProgressIndicator(progress = currentProgress, color = Color(0xB2000000), trackColor = Color(0xFFF7D8C2), modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxWidth()
                .height(7.dp)
                .clip(shape = RoundedCornerShape(8.dp))
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 12.dp)
                .align(Alignment.Center)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7D8C2)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                border = BorderStroke(3.dp, color = Color(0xFF242323))
            ){
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Soru ${index + 1}",
                        style = TextStyle(
                            fontSize = 29.sp,
                            lineHeight = 50.97.sp,
                            fontFamily = Righteous,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFF87617),
                            textAlign = TextAlign.Center,
                            letterSpacing = 0.9.sp,
                        ),
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        contentAlignment = Alignment.TopStart, modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "$questionList",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 27.18.sp,
                                fontFamily = Righteous,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF2E2E2E),
                                letterSpacing = 0.48.sp,
                            ),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7D8C2)),
                shape = RoundedCornerShape(0.dp),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
                    .wrapContentSize(),
                border = BorderStroke(3.dp, color = Color(0xFF242323))
            ){
                Column(modifier = Modifier.padding(start = 20.dp, top = 30.dp, end = 20.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Buttons(
                        answerList = answerList,
                        correctAnswer = correctAnswer ?: "",
                        onCorrect = { buttonIndex ->
                            buttonColorList[index][buttonIndex] = Color(0xFF09D60D)
                        },
                        onIncorrect = { buttonIndex ->
                            buttonColorList[index][buttonIndex] = Color(0xFFD60909)
                            userFalseAnswerCount++
                        },
                        onClicked = {
                            buttonStateList[index] = true
                        },
                        index = index,
                        buttonColorList = buttonColorList,
                        buttonStateList = buttonStateList,
                        addCorrectCount = {
                            userCorrectAnswerCount++
                            score =
                                ((userCorrectAnswerCount.toFloat() / questionCount) * 100.0f).toInt()
                        }
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(end = 10.dp, bottom = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_left),
                            contentDescription = "Previous",
                            modifier = Modifier
                                .size(50.dp, 50.dp)
                                .clickable(
                                    enabled = (index != 0),
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    if (index != 0) {
                                        index--
                                    }
                                },
                            colorFilter = if (index == 0) {
                                ColorFilter.tint(Color.Gray)
                            } else {
                                null
                            }

                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Text(
                            text = "${(index + 1)}/${questions.size}",
                            style = TextStyle(
                                fontSize = 25.sp,
                                lineHeight = 42.47.sp,
                                fontFamily = Righteous,
                                fontWeight = FontWeight(400),
                                color = Color(0xB2000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Image(
                            painter = painterResource(id = R.drawable.arrow_right),
                            contentDescription = "Next",
                            modifier = Modifier
                                .size(50.dp, 50.dp)
                                .clickable(
                                    enabled = (index != questions.size - 1),
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }) {
                                    if (index != questions.size - 1) {
                                        index++
                                    }
                                },
                            colorFilter = if (index == questions.size - 1) {
                                ColorFilter.tint(Color.Gray)
                            } else {
                                null
                            }
                        )
                    }

                }

            }
        }
        Button(
            onClick = {
                isStarted = false
                currentProgress = 0f
                navController.navigate("ScorePage/${score}/${questionCount}/${userCorrectAnswerCount}/${userFalseAnswerCount}")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xCB000000), contentColor = Color(
                0xFFDFD9D4
            )
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp, start = 36.dp, end = 36.dp)
        ) {
            Text(
                text = "Quizi Bitir",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Righteous,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Center,
                    letterSpacing = 1.9.sp
                )
            )
        }
    }
}

@Composable
fun Buttons(
    answerList: List<String>,
    correctAnswer: String?,
    onCorrect: (Int) -> Unit,
    onIncorrect: (Int) -> Unit,
    index: Int,
    buttonColorList: SnapshotStateList<MutableList<Color>>,
    buttonStateList: SnapshotStateList<Boolean>,
    onClicked: () -> Unit,
    addCorrectCount: () -> Unit
) {
    var correctIndex by remember { mutableIntStateOf(0)}

    for (correct in answerList.indices){
        if(answerList[correct] == correctAnswer){
            correctIndex = correct
        }
    }

    for(a in answerList.indices){
        AnswerButton(
            answer = answerList[a],
            correctAnswer = correctAnswer ?: "",
            onCorrect = onCorrect,
            onIncorrect = onIncorrect,
            index = index,
            buttonColorList = buttonColorList,
            buttonStateList = buttonStateList,
            buttonIndex = a,
            correctIndex = correctIndex,
            onClicked = onClicked,
            addCorrectCount = addCorrectCount
        )
    }
}

@Composable
fun AnswerButton(
    answer: String,
    correctAnswer: String,
    onCorrect: (Int) -> Unit,
    onIncorrect: (Int) -> Unit,
    index: Int,
    buttonColorList: SnapshotStateList<MutableList<Color>>,
    buttonStateList: SnapshotStateList<Boolean>,
    buttonIndex: Int,
    correctIndex : Int,
    onClicked : () -> Unit,
    addCorrectCount : () -> Unit
) {
    Button(
        onClick = {
            onClicked()
            buttonColorList[index] = mutableListOf(Color(0xFFF0741A),Color(0xFFF0741A),Color(0xFFF0741A),Color(0xFFF0741A))
            if(answer == correctAnswer) {
                addCorrectCount()
                onCorrect(buttonIndex)

            } else {
                onIncorrect(buttonIndex)
                onCorrect(correctIndex)
            }
                  },
        enabled = !buttonStateList[index],
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 3.dp,
                color = Color(0x70000000),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 20.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 20.dp
                )
            )
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        buttonColorList[index][buttonIndex],
                        buttonColorList[index][buttonIndex]
                    ),
                    startX = 0f,
                    endX = 500f
                ),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 20.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 20.dp
                )
            )
            .wrapContentHeight()


    )
    {
        Text(
            text = answer,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 27.18.sp,
                fontFamily = Righteous,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.48.sp,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}