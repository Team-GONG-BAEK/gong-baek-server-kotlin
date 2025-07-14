package entity.timeslot

import entity.user.User
import enums.WeekDay
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("LECTURE")
class LectureTimeSlot(
    weekDay: WeekDay,
    startTime: Double,
    endTime: Double,
    user: User
) : TimeSlotBase(weekDay, startTime, endTime, user)