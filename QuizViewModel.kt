package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel()
{
    private val questionBank = listOf(
        Question(R.string.question_travel, true),
        Question(R.string.question_free_throw, true),
        Question(R.string.question_three_pointer, false),
        Question(R.string.question_double_dribble, false),
        Question(R.string.question_carrying, true),
        Question(R.string.question_backcourt, true))
    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
    }
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}