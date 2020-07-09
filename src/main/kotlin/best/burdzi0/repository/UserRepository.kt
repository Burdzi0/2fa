package best.burdzi0.repository

import best.burdzi0.controller.dto.UserDto
import best.burdzi0.model.User
import io.micronaut.transaction.annotation.ReadOnly
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Singleton
open class UserRepository(
        private val entityManager: EntityManager
) {

    @ReadOnly
    open fun findById(id: Long): User? {
        return entityManager.find(User::class.java, id)
    }

    @Transactional
    open fun save(userDto: UserDto): User {
        val user = User(userDto.username, userDto.password, userDto.twoFactorEnable)
        entityManager.persist(user)
        return user
    }

    @ReadOnly
    open fun findAll(): List<User> {
        val qlString = "SELECT u FROM User u"
        val queryResult = entityManager.createQuery(qlString, User::class.java)
        return queryResult.resultList
    }

    @ReadOnly
    open fun findByUsername(username: String): User? {
        val qlString = "SELECT u FROM User u WHERE u.username = :username"
        val query = entityManager.createQuery(qlString, User::class.java)
        query.setParameter("username", username)
        return query.singleResult
    }

}