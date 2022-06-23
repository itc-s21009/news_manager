package jp.ac.it_college.std.s21009.news_manager.controller

import jp.ac.it_college.std.s21009.news_manager.application.service.CategoryService
import jp.ac.it_college.std.s21009.news_manager.database.record.CategoryRecord
import jp.ac.it_college.std.s21009.news_manager.presentation.form.RegisterCategoryRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/category")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterCategoryRequest) {
        categoryService.register(CategoryRecord(0, request.name))
    }
}