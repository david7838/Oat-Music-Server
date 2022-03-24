package com.oatmusic.oat_music_server.web.entity

import javax.persistence.*

@Entity
@Table(name = "student",
       uniqueConstraints = [UniqueConstraint(
           name = "email_unique",
           columnNames = arrayOf("email_address")
       )]
)
class StudentEntity (
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val studentId: Long? = null,

    val firstName: String?,

    val lastName: String?,

    @Column(
        name = "email_address",
        nullable = false
    )
    val emailId: String,

    @Embedded
    val guardian: Guardian? = null,

){
}