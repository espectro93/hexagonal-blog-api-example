package com.ggp.blog.domain.ports.out

import com.ggp.blog.domain.core.article.Article
import com.ggp.blog.domain.core.article.Author
import com.ggp.blog.domain.core.article.Slug
import com.ggp.blog.domain.core.article.Tag
import kotlinx.coroutines.flow.Flow

interface LoadArticle {
    suspend fun loadBy(slug: Slug): Article?
}

interface LoadAllArticles {
    fun loadAllBy(page: Int, size: Int): Flow<Article>
    fun loadAllBy(author: Author, page: Int, size: Int): Flow<Article>
    fun loadAllBy(tags: Set<Tag>, page: Int, size: Int): Flow<Article>
}

interface StoreArticle {
    suspend fun store(article: Article): Article
}

interface DeleteArticle {
    suspend fun deleteBy(slug: Slug)
}