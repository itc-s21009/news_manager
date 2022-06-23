package jp.ac.it_college.std.s21009.news_manager.domain.repository

import jp.ac.it_college.std.s21009.news_manager.database.record.CategoryRecord

interface CategoryRepository {
    fun findAll(): List<CategoryRecord>
    fun findById(id: Long): CategoryRecord?
    fun findByName(name: String): CategoryRecord?

    fun register(category: CategoryRecord)
}