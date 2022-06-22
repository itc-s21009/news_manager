package jp.ac.it_college.std.s21009.news_manager.controller

import jp.ac.it_college.std.s21009.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21009.news_manager.domain.enum.RoleType
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsController(
    private val newsService: NewsService,
) {

    @RequestMapping("/news")
    fun getNews(authentication: Authentication): List<BundledNewsRecord> {
        val roles =  authentication.authorities.map { RoleType.valueOf(it.authority) }
        return newsService.getList(roles.contains(RoleType.ADMIN))
    }

    @GetMapping("/news/{id}")
    fun getNews(@PathVariable id: Long): BundledNewsRecord {
        return newsService.getById(id, false)
    }
}