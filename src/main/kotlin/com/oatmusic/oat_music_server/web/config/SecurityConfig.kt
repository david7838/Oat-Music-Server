package com.oatmusic.oat_music_server.web.config

import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/*
＠EnableWebSecurity＠Import了三個配置類：

WebSecurityConfiguration：負責以WebSecurity建立名稱為springSecurityFilterChain的FilterChainProxy的bean，
                            此即是Spring Security的核心過濾器。
SpringWebMvcImportSelector：判斷環境中是否有DispatcherServlet，即是否為Spring MVC專案。
                                如果是則載入WebMvcSecurityConfiguration。
OAuth2ImportSelector：判斷環境中是否有OAuth2的ClientRegistration，在有OAuth2的環境才會用到。

＠EnableWebSecurity並包含了@EnableGlobalAuthentication，
其@Import了AuthenticationConfiguration配置，
負責建立驗證相關的AuthenticationManager與AuthenticationManagerBuilder配置。

被標註@EnableGlobalAuthentication的類別可用來配置AuthenticationManagerBuilder，
所以＠EnableWebSecurity也有同樣的效果。
 */
@Profile("test", "dev")
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers("/**")
    }
}