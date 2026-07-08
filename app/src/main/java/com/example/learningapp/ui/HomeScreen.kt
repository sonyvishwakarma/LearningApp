package com.example.learningapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.Lesson
import com.example.learningapp.NetworkCourse

// Mock Data structure mirroring your app's exact screens
val popularCoursesList = listOf(
    NetworkCourse(
        title = "Kotlin Fundamentals",
        level = "BEGINNER",
        instructor = "Aarav Sharma",
        thumbnail = "",
        description = "Start from zero and learn Kotlin's syntax, null safety, collections, and functions. By the end you'll be comfortable reading and writing idiomatic Kotlin.",
        lessons = listOf(
            Lesson(title = "Welcome & Setup", duration = "8 min", isFree = true, subtitle = "Set up Android Studio and run your first Kotlin file."),
            Lesson(title = "Variables & Null Safety", duration = "15 min", isFree = true, subtitle = "Understand mutable vs immutable types and null control mechanics."),
            Lesson(title = "Functions & Lambdas", duration = "18 min", isFree = false, subtitle = "Deep dive into higher order parameters and block expressions.")
        )
    ),
    NetworkCourse(
        title = "Jetpack Compose Essentials",
        level = "INTERMEDIATE",
        instructor = "Meera Nair",
        thumbnail = "",
        description = "Master modern Android UI development using declarative layouts, state composition, animations, and custom theme systems.",
        lessons = listOf(
            Lesson(title = "Introduction to Compose", duration = "10 min", isFree = true, subtitle = "Getting started with declarative layouts."),
            Lesson(title = "Managing Core State", duration = "18 min", isFree = false, subtitle = "Understanding remember and mutableStateOf.")
        )
    ),
    NetworkCourse(
        title = "Node.js from Scratch",
        level = "BEGINNER",
        instructor = "Sara Khan",
        thumbnail = "",
        description = "Build fast, scalable network applications. Learn Express routing, MongoDB integration, and safe RESTful API design.",
        lessons = listOf(
            Lesson(title = "What is Backend?", duration = "11 min", isFree = true, subtitle = "An overview of server architecture."),
            Lesson(title = "Express Framework Basics", duration = "22 min", isFree = false, subtitle = "Setting up api endpoints seamlessly.")
        )
    )
)

data class CategoryItem(val name: String, val count: String)
val categoryList = listOf(
    CategoryItem("Android Development", "3 courses"),
    CategoryItem("Backend & APIs", "2 courses"),
    CategoryItem("Product Design", "2 courses")
)

@Composable
fun CourseDesignThumbnail(title: String, level: String) {
    val gradientColors = if (level == "INTERMEDIATE") {
        listOf(Color(0xFF5A57DE), Color(0xFF4A47C5))
    } else if (title.contains("Node")) {
        listOf(Color(0xFF00B48B), Color(0xFF00896F))
    } else {
        listOf(Color(0xFF00A896), Color(0xFF028074))
    }

    Box(
        modifier = Modifier
            .size(width = 105.dp, height = 80.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Brush.linearGradient(gradientColors))
            .padding(10.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "Online",
                    color = Color.White,
                    fontSize = 6.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = title,
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Black,
                lineHeight = 12.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Composable
fun HomeScreen(onCourseClick: (NetworkCourse) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9))
                .padding(padding)
        ) {
            // 1. Top Header Profile Row with Notification Bell
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Welcome back", color = Color(0xFF7E7E7E), fontSize = 14.sp, fontFamily = FontFamily.SansSerif)
                        Text("Find your next skill", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontFamily = FontFamily.SansSerif)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(44.dp).background(Color.White, CircleShape)
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = null, tint = Color(0xFF111111))
                        }
                        Box(
                            modifier = Modifier.size(44.dp).background(Color(0xFF00A896), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("AS", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        }
                    }
                }
            }

            // 2. Interactive Styled Search Bar Card
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .background(Color.White, RoundedCornerShape(16.dp)),
                    placeholder = { Text("Search courses, topics...", color = Color(0xFF9E9E9E), fontSize = 15.sp) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF9E9E9E)) },
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF00A896),
                        unfocusedBorderColor = Color(0xFFEFEFEF)
                    )
                )
                Spacer(modifier = Modifier.height(28.dp))
            }

            // 3. Horizontal Categories Section Window List
            item {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Categories", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111))
                        Text("See all", color = Color(0xFF00A896), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    }
                    Spacer(modifier = Modifier.height(14.dp))

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        items(categoryList) { category ->
                            Card(
                                modifier = Modifier.width(135.dp).height(125.dp),
                                shape = RoundedCornerShape(24.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Box(
                                        modifier = Modifier.size(32.dp).background(Color(0xFFE0F4F2), RoundedCornerShape(10.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Box(modifier = Modifier.size(10.dp).background(Color(0xFF00A896), CircleShape))
                                    }
                                    Spacer(modifier = Modifier.height(14.dp))
                                    Text(category.name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111), lineHeight = 16.sp, maxLines = 2)
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(category.count, fontSize = 11.sp, color = Color(0xFF9E9E9E))
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(28.dp))
            }

            // 4. Popular Courses Section Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Popular courses", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF111111))
                    Text("See all", color = Color(0xFF00A896), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.height(14.dp))
            }

            // 5. Native Dynamic Course Cards Column List
            items(popularCoursesList.size) { index ->
                val course = popularCoursesList[index]
                val levelColor = if (course.level == "INTERMEDIATE") Color(0xFFE29526) else Color(0xFF00A896)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                        .clickable { onCourseClick(course) },
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CourseDesignThumbnail(
                            title = course.title ?: "",
                            level = course.level ?: "BEGINNER"
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(course.level ?: "BEGINNER", color = levelColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(course.title ?: "", color = Color(0xFF111111), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Text(course.instructor ?: "", color = Color(0xFF9E9E9E), fontSize = 13.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("⭐", fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(if (index == 1) "4.8" else if (index == 2) "4.5" else "4.7", color = Color(0xFF111111), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.width(16.dp))
                                Text("🕒", fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(if (index == 1) "9h" else if (index == 2) "7.5h" else "6.5h", color = Color(0xFF7E7E7E), fontSize = 13.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}