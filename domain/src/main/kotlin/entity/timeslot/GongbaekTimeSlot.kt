package entity.timeslot

import entity.user.User
import enums.WeekDay
import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "gongbaek_time_slot")
@PrimaryKeyJoinColumn(name = "id")
class GongbaekTimeSlot private constructor(
    weekDay: WeekDay,
    startTime: Double,
    endTime: Double,
    user: User
) : TimeSlotBase(weekDay, startTime, endTime, user) {

    companion object {
        fun of(
            weekDay: WeekDay,
            startTime: Double,
            endTime: Double,
            user: User
        ) = GongbaekTimeSlot(weekDay, startTime, endTime, user)
    }
}