package jp.ac.it_college.std.s21009.news_manager.application.service

import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord
import jp.ac.it_college.std.s21009.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
) {
    fun getList() : List<NewsRecord> {
        return newsRepository.findAll()
    }
}