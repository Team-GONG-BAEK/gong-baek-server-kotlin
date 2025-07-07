package entity.school

import entity.common.BaseTimeEntity
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
@Table(name = "school_major")
class SchoolMajor private constructor(
    school: School,
    majorName: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_major_id")
    val id: Long = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    var school: School = school
        protected set

    @Column(name = "school_major_name", nullable = false)
    var majorName: String = majorName
        protected set

    companion object {
        fun of(school: School, majorName: String) = SchoolMajor(school, majorName)
    }
}
