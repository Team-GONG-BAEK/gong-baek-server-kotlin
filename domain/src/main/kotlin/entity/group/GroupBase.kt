package entity.group

import entity.common.BaseTimeEntity
import entity.timeslot.GongbaekTimeSlot
import entity.user.User
import enums.Category
import enums.Status
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "group_base")
abstract class GroupBase protected constructor(
    creatorUser: User?,
    gongbaekTimeSlot: GongbaekTimeSlot,
    category: Category,
    coverImg: Int?,
    location: String,
    status: Status,
    maxPeopleCount: Int,
    currentPeopleCount: Int,
    introduction: String,
    title: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_user_id")
    var creatorUser: User? = creatorUser
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gongbaek_time_slot_id", nullable = false)
    var gongbaekTimeSlot: GongbaekTimeSlot = gongbaekTimeSlot
        protected set

    @Column(nullable = false)
    var category: Category = category
        protected set

    var coverImg: Int? = coverImg
        protected set

    @Column(nullable = false)
    var location: String = location
        protected set

    @Column(nullable = false)
    var status: Status = status
        protected set

    @Column(nullable = false)
    var maxPeopleCount: Int = maxPeopleCount
        protected set

    @Column(nullable = false)
    var currentPeopleCount: Int = currentPeopleCount
        protected set

    @Column(nullable = false)
    var introduction: String = introduction
        protected set

    @Column(nullable = false)
    var title: String = title
        protected set
}