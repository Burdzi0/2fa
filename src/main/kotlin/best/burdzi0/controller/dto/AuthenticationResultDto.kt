package best.burdzi0.controller.dto

import best.burdzi0.model.AuthenticationResult
import java.time.Instant

data class AuthenticationResultDto(val time: Instant, val result: AuthenticationResult)
