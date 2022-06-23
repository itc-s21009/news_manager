package jp.ac.it_college.std.s21009.news_manager.application.service

import jp.ac.it_college.std.s21009.news_manager.database.record.CategoryRecord
import jp.ac.it_college.std.s21009.news_manager.domain.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {

    fun register(category: CategoryRecord) {
        categoryRepository.findByName(category.name!!)?.let { throw IllegalArgumentException("存在するカテゴリ: ${category.name}") }
        categoryRepository.register(category)
    }
}