package com.oatmusic.oat_music_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OatMusicServerApplication

fun main(args: Array<String>) {
    runApplication<OatMusicServerApplication>(*args)
}
