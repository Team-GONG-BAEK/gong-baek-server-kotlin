package entity.timeslot

import entity.user.User
import enums.WeekDay
import jakarta.persistence.*

@Entity
@Table(name = "time_slot")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "slot_type")
open class TimeSlotBase(
    @Enumerated(EnumType.STRING)
    val weekDay: WeekDay,
    val startTime: Double,
    val endTime: Double,
    @ManyToOne
    val user: User
)
