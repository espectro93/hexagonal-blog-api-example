package com.ggp.blog.infrastructure.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@Configuration
@EnableReactiveMongoRepositories("com.ggp.blog.infrastructure.persistence.repositories")
class MongoConfig {
}