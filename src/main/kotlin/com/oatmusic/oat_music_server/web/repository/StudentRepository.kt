package com.oatmusic.oat_music_server.web.repository

import com.oatmusic.oat_music_server.web.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository: JpaRepository<StudentEntity, Long> {

}