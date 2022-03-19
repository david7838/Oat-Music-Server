package com.oatmusic.oat_music_server.web.controller

import com.oatmusic.oat_music_server.web.model.BeerDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("/api/v1/beer")
@RestController
class BeerController {

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
