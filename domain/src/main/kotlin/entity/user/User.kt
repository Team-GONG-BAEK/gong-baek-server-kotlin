package entity.user

import entity.common.BaseTimeEntity
import entity.school.School
import entity.school.SchoolMajor
import enums.Gender
import enums.Mbti
import enums.Platform
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class User private constructor(
    platform: Platform,
    platformId: String,
    email: String,
    school: School,
    schoolMajor: SchoolMajor,
    profileImg: Int?,
    nickname: String,
    enterYear: Int,
    mbti: Mbti,
    gender: Gender,
    introduction: String
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var platform: Platform = platform
        protected set

    @Column(nullable = false, unique = true)
    var platformId: String = platformId
        protected set

    @Column(nullable = false)
    var email: String = email
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    var school: School = school
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_major_id")
    var schoolMajor: SchoolMajor = schoolMajor
        protected set

    @Lob
    var refreshToken: String? = null
        protected set

    var profileImg: Int? = profileImg
        protected set

    @Column(nullable = false)
    var nickname: String = nickname
        protected set

    var enterYear: Int = enterYear
        protected set

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var mbti: Mbti = mbti
        protected set

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var gender: Gender = gender
        protected set

    @Column(nullable = false)
    var introduction: String = introduction
        protected set

    companion object {
        fun of(
            platform: Platform, platformId: String, email: String,
            school: School, schoolMajor: SchoolMajor, profileImg: Int?,
            nickname: String, enterYear: Int, mbti: Mbti,
            gender: Gender, introduction: String
        ) = User(
            platform, platformId, email, school, schoolMajor, profileImg,
            nickname, enterYear, mbti, gender, introduction
        )
    }

    fun updateRefreshToken(refreshToken: String?) {
        this.refreshToken = refreshToken
    }

    fun validateRefreshToken(refreshToken: String) =
        this.refreshToken == refreshToken
}
