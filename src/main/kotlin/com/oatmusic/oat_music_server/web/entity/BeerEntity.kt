package com.oatmusic.oat_music_server.web.entity

import javax.persistence.*

@Entity
@Table
class BeerEntity (

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val beerId: String,

    @Column(name = "beer_Name")
    val beerName: String
){
}