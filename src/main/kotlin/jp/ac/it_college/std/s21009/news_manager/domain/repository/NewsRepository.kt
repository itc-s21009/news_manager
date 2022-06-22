package jp.ac.it_college.std.s21009.news_manager.domain.repository

import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord

interface NewsRepository {
    fun findAll() : List<NewsRecord>
}