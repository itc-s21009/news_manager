package jp.ac.it_college.std.s21009.news_manager.presentation.form

import jp.ac.it_college.std.s21009.news_manager.domain.enum.RoleType
import java.time.LocalDateTime

data class RegisterNewsRequest(
    val title: String,
    val body: String,
    val categoryId: Long,
    val publishAt: LocalDateTime = LocalDateTime.now()
)
data class RegisterUserRequest(
    val username: String,
    var password: String,
    val viewName: String = username,
    val roleType: RoleType = RoleType.USER
)