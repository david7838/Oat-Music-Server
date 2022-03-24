package com.oatmusic.oat_music_server.web.entity

import javax.persistence.Embeddable

@Embeddable
class Guardian(
    var name: String = "",
    var email: String = "",
    var mobile: String = "",
) {
}
