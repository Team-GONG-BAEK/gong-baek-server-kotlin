package entity.userGroup

import entity.common.BaseTimeEntity
import entity.group.OnceGroup
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
@Table(name = "user_once_group")
class UserOnceGroup private constructor(
    participantUser: User,
    onceGroup: OnceGroup,
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_once_group_id")
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_user_id", nullable = false)
    var participantUser: User = participantUser
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "once_group_id", nullable = false)
    var onceGroup: OnceGroup = onceGroup
        protected set

    companion object {
        fun of(participantUser: User, onceGroup: OnceGroup) =
            UserOnceGroup(participantUser, onceGroup)
    }
}
