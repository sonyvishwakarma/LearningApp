
package com.example.learningapp.network

import com.example.learningapp.NetworkCourse
import retrofit2.http.GET

interface CourseApiService {
    // given api url 
    @GET("android-assesment/notes/refs/heads/main/data.json")
    suspend fun getPopularCourses(): List<NetworkCourse>
}