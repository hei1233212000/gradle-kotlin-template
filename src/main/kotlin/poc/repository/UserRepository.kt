package poc.repository

import poc.model.User

interface UserRepository {
    fun findById(id: Long): User
}