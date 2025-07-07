package entity.group

import entity.timeslot.GongbaekTimeSlot
import entity.user.User
import enums.Category
import enums.Status
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "every_group")
@PrimaryKeyJoinColumn(name = "id")
class EveryGroup private constructor(
    creatorUser: User?,
    gongbaekTimeSlot: GongbaekTimeSlot,
    category: Category,
    coverImg: Int,
    location: String,
    status: Status,
    maxPeopleCount: Int,
    currentPeopleCount: Int,
    introduction: String,
    title: String,
    dueDate: LocalDate
) : GroupBase(
    creatorUser,
    gongbaekTimeSlot,
    category,
    coverImg,
    location,
    status,
    maxPeopleCount,
    currentPeopleCount,
    introduction,
    title
) {

    @Column(nullable = false)
    var dueDate: LocalDate = dueDate
        protected set

    companion object {
        fun of(
            creatorUser: User?,
            gongbaekTimeSlot: GongbaekTimeSlot,
            category: Category,
            coverImg: Int,
            location: String,
            status: Status,
            maxPeopleCount: Int,
            currentPeopleCount: Int,
            introduction: String,
            title: String,
            dueDate: LocalDate
        ) = EveryGroup(
            creatorUser,
            gongbaekTimeSlot,
            category,
            coverImg,
            location,
            status,
            maxPeopleCount,
            currentPeopleCount,
            introduction,
            title,
            dueDate
        )
    }
}