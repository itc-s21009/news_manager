package jp.ac.it_college.std.s21009.news_manager.presentation.form

import java.time.LocalDateTime

data class RegisterNewsRequest(
    val title: String,
    val body: String,
    val categoryId: Long,
    val publishAt: LocalDateTime = LocalDateTime.now()
)