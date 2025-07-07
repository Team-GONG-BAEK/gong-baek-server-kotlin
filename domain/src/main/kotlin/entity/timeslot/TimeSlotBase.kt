package entity.timeslot

import entity.user.User
import enums.WeekDay
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
@Table(name = "time_slot_base")
abstract class TimeSlotBase protected constructor(
    weekDay: WeekDay,
    startTime: Double,
    endTime: Double,
    user: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_time_slot_id")
    val id: Long = 0

    @Column(nullable = false)
    var weekDay: WeekDay = weekDay
        protected set

    @Column(nullable = false)
    var startTime: Double = startTime
        protected set

    @Column(nullable = false)
    var endTime: Double = endTime
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set
}
