package jp.ac.it_college.std.s21009.news_manager.database.repository

import jp.ac.it_college.std.s21009.news_manager.database.record.UsersRecord
import jp.ac.it_college.std.s21009.news_manager.database.mapper.UsersDynamicSqlSupport.Users
import jp.ac.it_college.std.s21009.news_manager.database.mapper.UsersMapper
import jp.ac.it_college.std.s21009.news_manager.domain.repository.UserRepository
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.SqlTable
import org.mybatis.dynamic.sql.render.RenderingStrategies
import org.mybatis.dynamic.sql.util.kotlin.elements.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val usersMapper: UsersMapper
) : UserRepository {

    private val columnList = listOf(
        Users.id,
        Users.username,
        Users.password,
        Users.viewName,
        Users.roleType
    )

    override fun find(username: String): UsersRecord? {
        val selectStatement = select(columnList)
            .from(SqlTable.of("users"))
            .where(Users.username, isEqualTo(username))
            .build()
            .render(RenderingStrategies.MYBATIS3)
       return usersMapper.selectOne(selectStatement)
    }
}