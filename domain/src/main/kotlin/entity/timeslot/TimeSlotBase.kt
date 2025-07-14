package entity.timeslot

import entity.user.User
import enums.WeekDay
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("GONGBAEK")
class GongbaekTimeSlot(
    weekDay: WeekDay,
    startTime: Double,
    endTime: Double,
    user: User
) : TimeSlotBase(weekDay, startTime, endTime, user)
