package com.oatmusic.oat_music_server.web.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class BeerDto (
    val id: UUID,
    val version: Int,
    val createdDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
    val beerName: String,
    val beerStyle: BeerStyleEnum,
    val price: BigDecimal,
    val quantityOnHand: Int,
    val upc: Long,
        ){
}