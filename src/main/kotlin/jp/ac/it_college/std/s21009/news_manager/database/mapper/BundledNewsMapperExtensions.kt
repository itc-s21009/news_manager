package jp.ac.it_college.std.s21009.news_manager.database.mapper

import jp.ac.it_college.std.s21009.news_manager.database.mapper.NewsDynamicSqlSupport.News
import jp.ac.it_college.std.s21009.news_manager.database.mapper.CategoryDynamicSqlSupport.Category
import jp.ac.it_college.std.s21009.news_manager.database.mapper.UsersDynamicSqlSupport.Users
import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import org.mybatis.dynamic.sql.SqlBuilder.*
import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import java.time.LocalDateTime

private val news = SqlTable.of("news")
private val users = SqlTable.of("users")
private val category = SqlTable.of("category")

private val columnList = listOf(
    News.id,
    News.title,
    News.body,
    Category.name,
    News.publishAt,
    News.createAt,
    Users.viewName
)

fun BundledNewsMapper.select(includeUnpublished: Boolean): List<BundledNewsRecord> {
    val selectStatement = select(columnList)
        .from(news)
        .leftJoin(category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(users).on(News.userId, equalTo(Users.id))
    if (!includeUnpublished)
        selectStatement.where(News.publishAt, isLessThan(LocalDateTime.now()))

    return selectMany(selectStatement.build().render(RenderingStrategies.MYBATIS3))
}

fun BundledNewsMapper.selectByPrimaryKey(id: Long, includeUnpublished: Boolean): BundledNewsRecord {
    val selectStatement = select(columnList)
        .from(news)
        .leftJoin(category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(users).on(News.userId, equalTo(Users.id))
        .where(News.id, isEqualTo(id))
    if (!includeUnpublished)
        selectStatement.where(News.publishAt, isLessThan(LocalDateTime.now()))

    return selectOne(selectStatement.build().render(RenderingStrategies.MYBATIS3))
}