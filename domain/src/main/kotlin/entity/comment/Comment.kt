package entity.comment

import entity.common.BaseTimeEntity
import entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "comment")
class Comment private constructor(
    user: User?,
    isPublic: Boolean,
    body: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User? = user
        protected set

    @Column(nullable = false)
    var isPublic: Boolean = isPublic
        protected set

    @Column(nullable = false, length = 500)
    var body: String = body
        protected set

    companion object {
        fun of(user: User?, isPublic: Boolean, body: String) =
            Comment(user, isPublic, body)
    }
}
