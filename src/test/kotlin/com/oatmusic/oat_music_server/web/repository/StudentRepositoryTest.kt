package com.oatmusic.oat_music_server.web.repository

import com.oatmusic.oat_music_server.web.entity.StudentEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class StudentRepositoryTest(
    @Autowired private val studentRepository: StudentRepository
) {

    @Test
    fun `should find all student`(){
        //given
        val allStudent = studentRepository.findAll()

        //when
        val actual = 0
        print(allStudent.size)
        //then
        Assertions.assertTrue(allStudent.size >= 5 )

    }

    @Test
    fun `should create one student`(){
        //given
        val student = StudentEntity(
            firstName = "david",
            lastName = "yang",
            emailId = "123",
        )

        //when
        studentRepository.save(student)

        //then

    }
}