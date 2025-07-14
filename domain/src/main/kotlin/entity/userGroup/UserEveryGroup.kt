package entity.userGroup

import entity.common.BaseTimeEntity
import entity.group.EveryGroup
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
@Table(name = "user_every_group")
class UserEveryGroup private constructor(
    participantUser: User,
    everyGroup: EveryGroup
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_every_group_id")
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_user_id", nullable = false)
    var participantUser: User = participantUser
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "every_group_id", nullable = false)
    var everyGroup: EveryGroup = everyGroup
        protected set

    companion object {
        fun of(participantUser: User, everyGroup: EveryGroup) =
            UserEveryGroup(participantUser, everyGroup)
    }
}
