package jp.ac.it_college.std.s21009.news_manager.application.service

import jp.ac.it_college.std.s21009.news_manager.database.record.UsersRecord
import jp.ac.it_college.std.s21009.news_manager.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {
    fun findUser(username: String) : UsersRecord? {
        return userRepository.find(username)
    }
}