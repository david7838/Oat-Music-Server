package com.oatmusic.oat_music_server.web.controller

import com.oatmusic.oat_music_server.web.model.BeerDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.PostConstruct

@RequestMapping("/api/v1/beer")
@RestController
class BeerController {

    private val logger: Logger = LoggerFactory.getLogger(BeerController::class.java)

    @GetMapping("/{beerId}")
    fun getBeerById(@PathVariable beerId: UUID): ResponseEntity<BeerDto> =
        ResponseEntity<BeerDto>(BeerDto(id = UUID.randomUUID()), HttpStatus.OK)

    @PostMapping
    fun saveNewBeer(@RequestBody beerDto: BeerDto): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.CREATED)
    }

    @PutMapping("/{beerId}")
    fun updateBeerById(@PathVariable beerId: UUID, @RequestBody beerDto: BeerDto): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @DeleteMapping("/{beerId}")
    fun deleteBeerById(@PathVariable beerId: UUID): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}
