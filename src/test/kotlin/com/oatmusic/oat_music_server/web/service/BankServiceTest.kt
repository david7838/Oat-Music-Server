package com.oatmusic.oat_music_server.web.service

import com.oatmusic.oat_music_server.web.datasource.BankDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val bankDataSource: BankDataSource = mockk(relaxed = true)

    private val bankService = BankService(bankDataSource)

    @Test
    fun `should retrieve data from bankService`(){
        //given
//        every { bankDataSource.retrieveBanks() } returns emptyList()

        //when
        bankService.getBanks()

        //then
//        Assertions.assertThat(banks).isNotEmpty
        verify(exactly = 1) { bankDataSource.retrieveBanks() }
    }

}