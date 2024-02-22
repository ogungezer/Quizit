package com.example.quizit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.quizit.pages.QuizPage
import com.example.quizit.pages.ScorePage
import com.example.quizit.pages.WelcomePage
import com.example.quizit.ui.theme.QuizitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizitTheme{
                val navController : NavHostController = rememberNavController()
                QuizitApp(navController)
            }
        }
    }
}


@Composable
fun QuizitApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "WelcomePage"){
        composable(route = "WelcomePage"){
            WelcomePage(navController)
        }
        composable(route = "QuizPage"){
            QuizPage(navController)
        }
        composable(route = "ScorePage/{score}/{totalQuestionCount}/{totalCorrectAnsweredCount}/{totalFalseAnsweredCount}", arguments = listOf(
            navArgument("score"){
                type = NavType.IntType
            },
            navArgument("totalQuestionCount"){
                type = NavType.IntType
            },
            navArgument("totalCorrectAnsweredCount"){
                type = NavType.IntType
            },
            navArgument("totalFalseAnsweredCount"){
                type = NavType.IntType
            }
        )
        )
        {
            val score = remember {
                it.arguments?.getInt("score")
            }
            val totalQuestionCount = remember {
                it.arguments?.getInt("totalQuestionCount")
            }
            val totalCorrectAnsweredCount = remember {
                it.arguments?.getInt("totalCorrectAnsweredCount")
            }
            val totalFalseAnsweredCount = remember {
                it.arguments?.getInt("totalFalseAnsweredCount")
            }
            ScorePage(
                score = score ?: 0,
                totalQuestionCount = totalQuestionCount ?: 0,
                answeredCorrectQuestionCount = totalCorrectAnsweredCount ?: 0,
                answeredFalseQuestionCount = totalFalseAnsweredCount ?: 0,
                navController = navController
            )

        }
    }
}


