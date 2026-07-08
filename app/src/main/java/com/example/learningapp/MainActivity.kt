package com.example.learningapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.learningapp.ui.DetailsScreen
import com.example.learningapp.ui.HomeScreen
import com.example.learningapp.ui.LessonScreen

data class NetworkCourse(
    val title: String?,
    val thumbnail: String?,
    val level: String?,
    val instructor: String?,
    val description: String? = null,
    val lessons: List<Lesson>? = null
)

data class Lesson(
    val title: String?,
    val duration: String?,
    val isFree: Boolean?,
    val subtitle: String? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by remember { mutableStateOf("home") }
            var selectedCourse by remember { mutableStateOf<NetworkCourse?>(null) }
            var selectedLesson by remember { mutableStateOf<Lesson?>(null) }

            when (currentScreen) {
                "home" -> {
                    HomeScreen(
                        onCourseClick = { course ->
                            selectedCourse = course
                            currentScreen = "details"
                        }
                    )
                }
                "details" -> {
                    selectedCourse?.let { course ->
                        DetailsScreen(
                            course = course,
                            onBack = { currentScreen = "home" },
                            onLessonSelect = { lesson ->
                                selectedLesson = lesson
                                currentScreen = "player"
                            }
                        )
                    }
                }
                "player" -> {
                    selectedLesson?.let { lesson ->
                        LessonScreen(
                            lesson = lesson,
                            courseTitle = selectedCourse?.title ?: "Course",
                            onBack = { currentScreen = "details" }
                        )
                    }
                }
            }
        }
    }
}