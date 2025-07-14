package entity.timeslot

import entity.common.BaseTimeEntity
import entity.user.User
import enums.WeekDay
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
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
@Table(name = "time_slot")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "slot_type", discriminatorType = DiscriminatorType.STRING)
open class TimeSlotBase protected constructor(
    @Enumerated(EnumType.STRING)
    val weekDay: WeekDay,

    @Column(nullable = false)
    val startTime: Double,

    @Column(nullable = false)
    val endTime: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_time_slot_id")
    val id: Long = 0
}
