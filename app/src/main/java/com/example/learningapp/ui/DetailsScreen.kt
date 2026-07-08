package com.example.learningapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.learningapp.Lesson
import com.example.learningapp.NetworkCourse

@Composable
fun DetailsScreen(course: NetworkCourse, onBack: () -> Unit, onLessonSelect: (Lesson) -> Unit) {
    val lessonsList = course.lessons ?: emptyList()

    Scaffold(
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shadowElevation = 12.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 20.dp)
                        .navigationBarsPadding(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("PRICE", color = Color(0xFF9E9E9E), fontSize = 11.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
                        Text("Free", color = Color(0xFF00A896), fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .height(54.dp)
                            .width(230.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00A896))
                    ) {
                        Text("Enroll now", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.SansSerif)
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9))
                .padding(padding)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .background(Color(0xFF00A896))
                ) {
                    AsyncImage(
                        model = course.thumbnail,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.35f
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = onBack,
                            modifier = Modifier.size(44.dp).background(Color.White.copy(alpha = 0.9f), CircleShape)
                        ) {
                            Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color(0xFF111111), modifier = Modifier.size(20.dp))
                        }
                    }
                }

                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        text = course.title ?: "Kotlin Fundamentals",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF111111),
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Everything you need to start writing Kotlin",
                        color = Color(0xFF7E7E7E),
                        fontSize = 16.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⭐ 4.7", fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text("🕒 6.5h", color = Color(0xFF7E7E7E), fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(course.level ?: "Beginner", color = Color(0xFF00A896), fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
                    ) {
                        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(46.dp).background(Color(0xFF00A896), CircleShape), contentAlignment = Alignment.Center) {
                                Text("AS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp, fontFamily = FontFamily.SansSerif)
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(course.instructor ?: "Aarav Sharma", fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontSize = 15.sp, fontFamily = FontFamily.SansSerif)
                                Text("Senior Android Engineer", color = Color(0xFF7E7E7E), fontSize = 13.sp, fontFamily = FontFamily.SansSerif)
                            }
                            Text("Follow", color = Color(0xFF00A896), fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = course.description ?: "Start from zero and learn syntax basics.",
                        color = Color(0xFF424242),
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(28.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Course content", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontFamily = FontFamily.SansSerif)
                        Text("${lessonsList.size} lessons · 41 min", color = Color(0xFF7E7E7E), fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                }
            }

            items(lessonsList) { lesson ->
                val isLessonFree = lesson.isFree ?: false
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 6.dp)
                        .clickable { if (isLessonFree) onLessonSelect(lesson) },
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(if (isLessonFree) Color(0xFFE0F4F2) else Color(0xFFF5F5F5), CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (isLessonFree) Icons.Default.PlayArrow else Icons.Default.Lock,
                                    contentDescription = null,
                                    tint = if (isLessonFree) Color(0xFF00A896) else Color(0xFF9E9E9E),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(lesson.title ?: "", fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontSize = 15.sp)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(lesson.duration ?: "", fontSize = 13.sp, color = Color(0xFF7E7E7E))
                            }
                        }
                        if (isLessonFree) {
                            Box(modifier = Modifier.background(Color(0xFFE0F4F2), RoundedCornerShape(8.dp)).padding(horizontal = 10.dp, vertical = 4.dp)) {
                                Text("FREE", color = Color(0xFF00A896), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }
    }
}