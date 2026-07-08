package com.example.learningapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningapp.Lesson

@Composable
fun LessonScreen(lesson: Lesson, courseTitle: String, onBack: () -> Unit) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9))
                .padding(padding)
        ) {
            // Video Player Top Container with Circular Progress Controls
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color(0xFF043B35))
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.padding(16.dp).size(40.dp).background(Color.Black.copy(alpha = 0.2f), CircleShape)
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null, tint = Color.White)
                }

                Box(
                    modifier = Modifier.size(64.dp).background(Color.White, CircleShape).align(Alignment.Center),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color(0xFF00A896), modifier = Modifier.size(32.dp))
                }

                // Timeline Scrubbers
                Column(
                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(20.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("02:14", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text("06:00", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(4.dp).background(Color.White.copy(alpha = 0.25f), RoundedCornerShape(2.dp))) {
                        Box(modifier = Modifier.fillMaxWidth(0.35f).fillMaxHeight().background(Color(0xFF00A896), RoundedCornerShape(2.dp)))
                    }
                }
            }

            // Description and Lesson Content Tab Section
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "LESSON 1 · ${courseTitle.uppercase()}",
                    color = Color(0xFF00A896),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = lesson.title ?: "",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF111111),
                    fontFamily = FontFamily.SansSerif
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = lesson.subtitle ?: "Course content overview initialized.",
                    color = Color(0xFF7E7E7E),
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Navigation Tabs Bar
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(end = 28.dp)) {
                        // FIXED: Changed 'architecturalWeight' to 'fontWeight'
                        Text("Lessons", fontWeight = FontWeight.Bold, color = Color(0xFF111111), fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(modifier = Modifier.width(44.dp).height(3.dp).background(Color(0xFF00A896), RoundedCornerShape(1.5.dp)))
                    }
                    Text("Notes", color = Color(0xFF7E7E7E), modifier = Modifier.padding(end = 28.dp), fontSize = 16.sp)
                    Text("Resources", color = Color(0xFF7E7E7E), fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Highlighted Container showing the active playlist element
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F4F2))
                ) {
                    Row(modifier = Modifier.padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(38.dp).background(Color(0xFF00A896), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            // FIXED: Changed fontSize from '14.dp' to '14.sp'
                            Text("||", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(lesson.title ?: "", fontWeight = FontWeight.Bold, color = Color(0xFF044D44), fontSize = 15.sp)
                            Spacer(modifier = Modifier.height(2.dp))
                            Text("Now playing · ${lesson.duration}", fontSize = 13.sp, color = Color(0xFF00A896))
                        }
                    }
                }
            }
        }
    }
}