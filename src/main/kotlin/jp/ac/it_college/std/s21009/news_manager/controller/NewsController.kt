package jp.ac.it_college.std.s21009.news_manager.controller

import jp.ac.it_college.std.s21009.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController(
    private val newsService: NewsService
) {

    @GetMapping("/news")
    fun getNews(): List<NewsRecord> {
        return newsService.getList()
    }
}