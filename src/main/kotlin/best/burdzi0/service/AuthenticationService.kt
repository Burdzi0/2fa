package best.burdzi0.service

import best.burdzi0.controller.dto.AuthenticationResultDto
import best.burdzi0.model.AuthenticationResult
import best.burdzi0.repository.UserRepository
import best.burdzi0.service.exception.UserNotFoundException
import java.time.Instant.now
import javax.inject.Singleton

@Singleton
class AuthenticationService(private val userRepository: UserRepository,
                            private val passwordEncoder: PasswordEncoder) {


    fun authenticate(username: String, password: String): AuthenticationResultDto {
        // database call
        val user = userRepository.findByUsername(username) ?: throw UserNotFoundException("User not found")

        // if ok then send push notification
        return if (user.password == passwordEncoder.encode(password)) {

            if (user.twoFactorEnabled) {
                // store user in redis for given time
                // send notification
                // another controller will listen for response
                sendPushNotification()
                AuthenticationResultDto(now(), AuthenticationResult.UNSUCCESSFUL)
            } else {
                AuthenticationResultDto(now(), AuthenticationResult.SUCCESSFUL)
            }
        } else {
            AuthenticationResultDto(now(), AuthenticationResult.UNSUCCESSFUL)
        }
    }

    private fun sendPushNotification() {
        TODO("send push notification")
    }
}