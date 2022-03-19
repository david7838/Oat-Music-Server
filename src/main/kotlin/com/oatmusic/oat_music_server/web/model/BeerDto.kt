package com.oatmusic.oat_music_server.web.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class BeerDto (
    val id: UUID,
    val version: Int = 1,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastModifiedDate: LocalDateTime = LocalDateTime.now(),
    val beerName: String = "default name",
    val beerStyle: BeerStyleEnum = BeerStyleEnum.ALE,
    val price: BigDecimal = BigDecimal(1),
    val quantityOnHand: Int = 1,
    val upc: Long = 100L,
        ){
}