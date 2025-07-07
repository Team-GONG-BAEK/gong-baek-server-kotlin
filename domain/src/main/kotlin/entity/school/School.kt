package entity.school

import entity.common.BaseTimeEntity
import entity.user.User
import jakarta.persistence.*

@Entity
@Table(
    name = "school",
    indexes = [Index(name = "school_name_idx", columnList = "schoolName")]
)
class School private constructor(
    schoolName: String,
    schoolDomain: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    val id: Long = 0

    @Column(nullable = false, unique = true)
    var schoolName: String = schoolName
        protected set

    @Column(nullable = false)
    var schoolDomain: String = schoolDomain
        protected set

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    protected val _schoolMajors: MutableList<SchoolMajor> = mutableListOf()
    val schoolMajors: List<SchoolMajor> get() = _schoolMajors.toList()

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY)
    protected val _users: MutableList<User> = mutableListOf()
    val users: List<User> get() = _users.toList()

    companion object {
        fun of(schoolName: String, schoolDomain: String) = School(schoolName, schoolDomain)
    }
}
