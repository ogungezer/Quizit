package com.example.quizit.model

data class Question(
    val question : String? = null,
    val answers: List<String> = listOf(),
    val correctAnswer : String? = null
)
