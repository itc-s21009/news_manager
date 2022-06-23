package jp.ac.it_college.std.s21009.news_manager.controller

import jp.ac.it_college.std.s21009.news_manager.application.service.CategoryService
import jp.ac.it_college.std.s21009.news_manager.database.record.CategoryRecord
import jp.ac.it_college.std.s21009.news_manager.presentation.form.RegisterCategoryRequest
import jp.ac.it_college.std.s21009.news_manager.presentation.form.UpdateCategoryRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/category")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterCategoryRequest) {
        categoryService.register(CategoryRecord(0, request.name))
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long) {
        categoryService.delete(id)
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateCategoryRequest) {
        categoryService.update(request.id, request.name)
    }
}