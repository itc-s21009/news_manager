package jp.ac.it_college.std.s21009.news_manager.database.repository

import jp.ac.it_college.std.s21009.news_manager.database.mapper.CategoryDynamicSqlSupport.Category
import jp.ac.it_college.std.s21009.news_manager.database.mapper.CategoryMapper
import jp.ac.it_college.std.s21009.news_manager.database.mapper.deleteByPrimaryKey
import jp.ac.it_college.std.s21009.news_manager.database.mapper.insert
import jp.ac.it_college.std.s21009.news_manager.database.record.CategoryRecord
import jp.ac.it_college.std.s21009.news_manager.domain.enum.NewsManagerTables
import jp.ac.it_college.std.s21009.news_manager.domain.repository.CategoryRepository
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val categoryMapper: CategoryMapper
): CategoryRepository {

    private val columnList = listOf(
        Category.id,
        Category.name,
    )

    override fun findAll(): List<CategoryRecord> {
        val selectStatement = select(columnList)
            .from(NewsManagerTables.CATEGORY)
            .build()
            .render(RenderingStrategies.MYBATIS3)
        return categoryMapper.selectMany(selectStatement)
    }

    override fun findById(id: Long): CategoryRecord? {
        val selectStatement = select(columnList)
            .from(NewsManagerTables.CATEGORY)
            .where(Category.id, isEqualTo(id))
            .build()
            .render(RenderingStrategies.MYBATIS3)
        return categoryMapper.selectOne(selectStatement)
    }
    override fun findByName(name: String): CategoryRecord? {
        val selectStatement = select(columnList)
            .from(NewsManagerTables.CATEGORY)
            .where(Category.name, isEqualTo(name))
            .build()
            .render(RenderingStrategies.MYBATIS3)
        return categoryMapper.selectOne(selectStatement)
    }

    override fun register(category: CategoryRecord) {
        categoryMapper.insert(category)
    }

    override fun delete(id: Long) {
        categoryMapper.deleteByPrimaryKey(id)
    }

    override fun updateName(id: Long, name: String) {
        val updateStatement = update(NewsManagerTables.CATEGORY)
            .set(Category.name).equalTo(name)
            .where(Category.id, isEqualTo(id))
            .build()
            .render(RenderingStrategies.MYBATIS3)
        categoryMapper.update(updateStatement)
    }
}