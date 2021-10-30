package com.ggp.blog.domain.core.user

import com.ggp.blog.domain.ports.`in`.CreateUserUseCase
import com.ggp.blog.domain.ports.`in`.EditUserUseCase
import com.ggp.blog.domain.ports.`in`.GetUserUseCase
import com.ggp.blog.domain.ports.out.DeleteUser
import com.ggp.blog.domain.ports.out.LoadUser
import com.ggp.blog.domain.ports.out.StoreUser

class UserService(
        private val loadUser: LoadUser,
        private val storeUser: StoreUser,
        private val deleteUser: DeleteUser
) : CreateUserUseCase, EditUserUseCase, GetUserUseCase {
    override suspend fun create(user: User): User {
        return storeUser.store(user)
    }

    override suspend fun editBy(userId: UserId, email: Email?, profile: Profile?): User {
        val user = loadUser.loadById(userId)?.let {
            User(
                    id = it.id,
                    profile = profile ?: it.profile,
                    username = it.username,
                    email = email ?: it.email,
            )
        } ?: throw Exception("User not found")

        return storeUser.store(user)
    }

    override suspend fun getBy(userId: UserId): User? {
        return loadUser.loadById(userId)
    }

}