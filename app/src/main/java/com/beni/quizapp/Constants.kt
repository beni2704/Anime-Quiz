package com.beni.quizapp

object Constants {

    const val username :String ="username"
    const val total_question: String = "total_questions"
    const val correct_answers: String = "correct_answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Which anime is this picture from?",
            R.drawable.blue_lock,
            "Blue Lock",
            "Tsubasa",
            "Naruto",
            "Haikyuu",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            "Which anime is this picture from?",
            R.drawable.boku_no_hero,
            "Boku no hero",
            "Hunter x Hunter",
            "One Piece",
            "Danmachi",
            1
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            "Which anime is this picture from?",
            R.drawable.dorohedoro,
            "Kageki Shoujo",
            "Dorohedoro",
            "Steins Gate",
            "Gintama",
            2
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            "Which anime is this picture from?",
            R.drawable.haikyuu,
            "Mob Psycho",
            "Kimi no Na wa.",
            "Koe no Katachi",
            "Haikyuu",
            4
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            "Which anime is this picture from?",
            R.drawable.isekai_ojisan,
            "Isekai Quartet",
            "Sword Art Online",
            "Isekai Ojisan",
            "Shingeki no Kyojin",
            3
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            "Which anime is this picture from?",
            R.drawable.kaguya_sama,
            "Hajime no Ippo",
            "Cowboy Bebop",
            "Highschool Romance",
            "Kaguya-sama",
            4
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            "Which anime is this picture from?",
            R.drawable.kanojo_okarishimasu,
            "Kanojo Okarishimasu",
            "Aho Girl",
            "Made in Abyss",
            "86",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            "Which anime is this picture from?",
            R.drawable.overlord,
            "Summertime Render",
            "Overlord",
            "Shigatsu wa Kimi no Uso",
            "Monster",
            2
        )
        questionList.add(que8)

        val que9 = Question(
            9,
            "Which anime is this picture from?",
            R.drawable.shokugeki_no_souma,
            "Shokugeki no Souma",
            "Monogatari Series",
            "Nana",
            "Yuru Camp",
            1
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            "Which anime is this picture from?",
            R.drawable.tokyo_revengers,
            "One Punch Man",
            "Tokyo Revengers",
            "Steins Gate",
            "Fullmetal Alchemist",
            2
        )
        questionList.add(que10)

        return questionList
    }
}