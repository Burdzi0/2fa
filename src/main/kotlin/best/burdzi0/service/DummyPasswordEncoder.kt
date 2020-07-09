package best.burdzi0.service

class DummyPasswordEncoder : PasswordEncoder {

    override fun encode(password: String): String {
        return password
    }
}