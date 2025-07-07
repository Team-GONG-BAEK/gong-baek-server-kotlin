package entity.advertisement

import entity.common.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "advertisement")
class Advertisement private constructor(
    imageUrl: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Column(nullable = false)
    var imageUrl: String = imageUrl
        protected set

    companion object {
        fun of(imageUrl: String) = Advertisement(imageUrl)
    }
}
