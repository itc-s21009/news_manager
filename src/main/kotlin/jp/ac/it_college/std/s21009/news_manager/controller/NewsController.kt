package jp.ac.it_college.std.s21009.news_manager.controller

import jp.ac.it_college.std.s21009.news_manager.application.service.NewsManagerUserDetails
import jp.ac.it_college.std.s21009.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord
import jp.ac.it_college.std.s21009.news_manager.domain.enum.RoleType
import jp.ac.it_college.std.s21009.news_manager.presentation.form.RegisterNewsRequest
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

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

    @PostMapping("/post")
    fun register(@RequestBody request: RegisterNewsRequest, authentication: Authentication) {
        val principal = authentication.principal as NewsManagerUserDetails
        newsService.register(
            NewsRecord(
                0,
                request.title,
                request.categoryId,
                request.publishAt,
                LocalDateTime.now(),
                principal.id,
                request.body
            )
        )
    }
}