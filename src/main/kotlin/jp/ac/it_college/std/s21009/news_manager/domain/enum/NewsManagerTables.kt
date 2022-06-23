package jp.ac.it_college.std.s21009.news_manager.domain.enum

import org.mybatis.dynamic.sql.SqlTable

class NewsManagerTables {
    companion object {
        val NEWS: SqlTable = SqlTable.of("news")
        val USERS: SqlTable = SqlTable.of("users")
        val CATEGORY: SqlTable = SqlTable.of("category")
    }
}