package best.burdzi0.model

import javax.persistence.*

@Entity
@Table(name = "USER")
data class User(
        @Id @GeneratedValue val id: Long,
        @Column(name = "username", unique = true, nullable = false) val username: String,
        @Column(name = "password", nullable = false) val password: String,
        @Column(name = "two_factor_enabled", nullable = false) val twoFactorEnabled: Boolean
) {
    constructor(username: String, password: String, twoFactorEnabled: Boolean) : this(0, username, password, twoFactorEnabled)
}