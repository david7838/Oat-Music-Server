package com.oatmusic.oat_music_server.web.model

import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable

class BeerPagedList : PageImpl<BeerDto> {
    constructor(content: MutableList<BeerDto>, pageable: Pageable, total: Long) : super(content, pageable, total)
    constructor(content: MutableList<BeerDto>) : super(content)
}