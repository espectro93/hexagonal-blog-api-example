package com.ggp.blog.domain.ports.out

import com.ggp.blog.domain.core.comment.Comment

interface LoadComment {
    suspend fun load(commentId: String): Comment?
}

interface LoadAllForArticle {
    suspend fun loadAllForArticle(articleId: String): List<Comment>
}

interface LoadAllForParentComment {
    suspend fun loadAllForArticle(parentId: String): List<Comment>
}

interface StoreComment {
    suspend fun store(comment: Comment): Comment
}

interface DeleteComment {
    suspend fun delete(commentId: String)
}