package best.burdzi0.service

interface PasswordEncoder {

    fun encode(password: String): String
}
