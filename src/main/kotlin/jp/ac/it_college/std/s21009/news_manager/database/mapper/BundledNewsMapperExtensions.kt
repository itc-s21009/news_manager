package jp.ac.it_college.std.s21009.news_manager.database.mapper

import jp.ac.it_college.std.s21009.news_manager.database.mapper.NewsDynamicSqlSupport.News
import jp.ac.it_college.std.s21009.news_manager.database.mapper.CategoryDynamicSqlSupport.Category
import jp.ac.it_college.std.s21009.news_manager.database.mapper.UsersDynamicSqlSupport.Users
import jp.ac.it_college.std.s21009.news_manager.database.record.BundledNewsRecord
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo

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

fun BundledNewsMapper.select(): List<BundledNewsRecord> {
    val selectStatement = select(columnList)
        .from(news)
        .leftJoin(category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(users).on(News.userId, equalTo(Users.id))
        .build().render(RenderingStrategies.MYBATIS3)
    return selectMany(selectStatement)
}

fun BundledNewsMapper.selectByPrimaryKey(id: Long): BundledNewsRecord {
    val selectStatement = select(columnList)
        .from(news)
        .leftJoin(category).on(News.categoryId, equalTo(Category.id))
        .leftJoin(users).on(News.userId, equalTo(Users.id))
        .where(News.id, isEqualTo(id))
        .build().render(RenderingStrategies.MYBATIS3)
    return selectOne(selectStatement)
}