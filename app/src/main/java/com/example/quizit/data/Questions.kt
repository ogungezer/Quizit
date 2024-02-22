package com.example.quizit.data

import com.example.quizit.model.Question

object Questions {
    val questions : List<Question> = listOf(
        Question(
            question = "Hangi yıl Amerika Birleşik Devletleri'nin bağımsızlığı ilan edildi?",
            answers = listOf("A) 1776", "B) 1789", "C) 1812", "D) 1492"),
            correctAnswer = "A) 1776"
        ),

        Question(
            question = "Dünyanın en büyük okyanusu hangisidir?",
            answers = listOf("A) Atlas Okyanusu", "B) Hint Okyanusu", "C) Büyük Okyanus", "D) Arktik Okyanusu"),
            correctAnswer = "C) Büyük Okyanus"
        ),

        Question(
            question = "Kimya'da 'H2O' kimyasal formülü neyi temsil eder?",
            answers = listOf("A) Hidrojen dioksit", "B) Hidrojen peroksit", "C) Su", "D) Hidrojen oksit"),
            correctAnswer = "C) Su"
        ),

        Question(
            question = "Hangi yazar, 'Savaş ve Barış' adlı ünlü romanı yazmıştır?",
            answers = listOf("A) Charles Dickens", "B) Jane Austen", "C) Fyodor Dostoyevsky", "D) Leo Tolstoy"),
            correctAnswer = "D) Leo Tolstoy"
        ),

        Question(
            question = "Hangi film, 1994'te En İyi Film dalında Oscar ödülü kazandı?",
            answers = listOf("A) The Shawshank Redemption", "B) Pulp Fiction", "C) Forrest Gump", "D) Schindler's List"),
            correctAnswer = "D) Schindler's List"
        ),

        Question(
            question = "Teniste Grand Slam turnuvalarından biri hangisidir?",
            answers = listOf("A) Wimbledon", "B) Super Bowl", "C) The Masters", "D) Tour de France"),
            correctAnswer = "A) Wimbledon"
        ),

        Question(
            question = "'Mona Lisa' tablosu hangi İtalyan ressamın eseridir?",
            answers = listOf("A) Pablo Picasso", "B) Vincent van Gogh", "C) Leonardo da Vinci", "D) Michelangelo"),
            correctAnswer = "C) Leonardo da Vinci"
        ),

        Question(
            question = "'Hey Jude' şarkısının söz yazarları kimdir?",
            answers = listOf("A) John Lennon ve Paul McCartney", "B) Mick Jagger ve Keith Richards", "C) Bob Dylan", "D) Elvis Presley"),
            correctAnswer = "A) John Lennon ve Paul McCartney"
        ),

        Question(
            question = "Isaac Asimov'un ünlü Robot serisi hangi yıl yayımlanmaya başladı?",
            answers = listOf("A) 1939", "B) 1950", "C) 1965", "D) 1977"),
            correctAnswer = "B) 1950"
        ),

        Question(
            question = "Hangi programlama dili 'Hello World!' mesajını ekranda göstermek için sıklıkla kullanılır?",
            answers = listOf("A) Python", "B) Java", "C) C++", "D) Ruby"),
            correctAnswer = "A) Python"
        ),
    )
}