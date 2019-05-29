package poc.service

import poc.repository.UserRepository

class UserService(
    private val userRepository: UserRepository
) {
    fun findById(id: Long) = userRepository.findById(id)
}