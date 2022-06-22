package jp.ac.it_college.std.s21009.news_manager.application.service

import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord
import jp.ac.it_college.std.s21009.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService(
    private val newsRepository: NewsRepository
) {
    fun getList(includeUnpublished: Boolean) : List<BundledNewsRecord> {
        return newsRepository.findAll(includeUnpublished)
    }

    fun getById(id: Long, includeUnpublished: Boolean) : BundledNewsRecord {
        return newsRepository.findById(id, includeUnpublished)
    }

    fun register(news: NewsRecord) {
        newsRepository.register(news)
    }
}