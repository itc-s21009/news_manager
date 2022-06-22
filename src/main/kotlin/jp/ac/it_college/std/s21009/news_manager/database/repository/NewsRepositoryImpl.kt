package jp.ac.it_college.std.s21009.news_manager.database.repository

import jp.ac.it_college.std.s21009.news_manager.database.mapper.NewsDynamicSqlSupport.News
import jp.ac.it_college.std.s21009.news_manager.database.record.NewsRecord
import jp.ac.it_college.std.s21009.news_manager.database.mapper.NewsMapper
import jp.ac.it_college.std.s21009.news_manager.domain.repository.NewsRepository
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.springframework.stereotype.Repository

@Repository
class NewsRepositoryImpl(
    private val newsMapper: NewsMapper
) : NewsRepository {

    private val columnList = listOf(
        News.id,
        News.title,
        News.body,
        News.categoryId,
        News.publishAt,
        News.createAt,
        News.userId
    )

    override fun findAll(): List<NewsRecord> {
        val selectStatement = select(columnList).from(SqlTable.of("news"))
            .build().render(RenderingStrategies.MYBATIS3)
        return newsMapper.selectMany(selectStatement)
    }
}