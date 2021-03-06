package com.ggp.blog.infrastructure.persistence.repositories

import com.ggp.blog.domain.core.article.Slug
import com.ggp.blog.domain.core.user.FavoredArticle
import com.ggp.blog.domain.core.user.FavoredArticleId
import com.ggp.blog.domain.core.user.UserId
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface FavoredArticleRepository : ReactiveMongoRepository<FavoredArticle, FavoredArticleId> {
    fun findAllById(favoredArticleId: FavoredArticleId, pageable: Pageable): Flux<FavoredArticle>
    fun findByUserIdAndSlug(userId: UserId, slug: Slug): FavoredArticle?
}