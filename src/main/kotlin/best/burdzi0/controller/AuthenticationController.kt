package best.burdzi0.controller

import best.burdzi0.controller.dto.AuthenticationResultDto
import best.burdzi0.controller.dto.CredentialsDto
import best.burdzi0.service.AuthenticationService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/authenticate")
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @Post
    fun authenticate(credentials: CredentialsDto): AuthenticationResultDto {
        return authenticationService.authenticate(credentials.username, credentials.password)
    }
}