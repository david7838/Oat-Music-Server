package com.oatmusic.oat_music_server.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.oatmusic.oat_music_server.web.model.BeerDto
import com.oatmusic.oat_music_server.web.model.BeerStyleEnum
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.put
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import kotlin.time.Duration

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(BeerController::class)
internal class BeerControllerTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper
) {

    @Test
    fun getBeerById() {
        mockMvc.get("/api/v1/beer/${UUID.randomUUID().toString()}").andDo { print() }.andExpect { status { isOk() } }
    }

    @Test
    fun saveNewBeer() {

    }

    @Test
    fun `should save New Beer When Provide not existing beeerId and BeerDto `(){
        //given
        val validBeer = BeerDto(
            UUID.randomUUID(),
            2,
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(1),
            "myBeer",
            BeerStyleEnum.ALE,
            BigDecimal(200),
            3,
            100L
        )

        //when
        val performPostRequest = mockMvc.post("/api/v1/beer") {
            contentType = APPLICATION_JSON
            content = objectMapper.writeValueAsString(validBeer)
        }
        //then
        performPostRequest.andDo { print() }
            .andExpect {
                status { isCreated() }
            }
    }

    @Test
    fun updateBeerById() {
    }

    @Test
    fun `should update existing beerDto when provide existing beerId and new beerdto`(){
        //given
        val existingBeerId = UUID.randomUUID()
        val updatedBeerDto = BeerDto(
            existingBeerId,
            2,
            LocalDateTime.now(),
            LocalDateTime.now().plusDays(1),
            "myBeer",
            BeerStyleEnum.ALE,
            BigDecimal(200),
            3,
            100L
        )
        //when
        val performPutRequest = mockMvc.put("/api/v1/beer/$existingBeerId") {
            contentType = APPLICATION_JSON
            content = objectMapper.writeValueAsString(updatedBeerDto)
        }

        //then
        performPutRequest.andDo { print() }
            .andExpect {
                status { isNoContent() }
            }
    }

    @Test
    fun deleteBeerById() {
    }
}