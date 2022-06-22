package jp.ac.it_college.std.s21009.news_manager.application.service

import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21009.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
) {
    fun getList() : List<BundledNewsRecord> {
        return newsRepository.findAll()
    }

    fun getById(id: Long) : BundledNewsRecord {
        return newsRepository.findById(id)
    }
}