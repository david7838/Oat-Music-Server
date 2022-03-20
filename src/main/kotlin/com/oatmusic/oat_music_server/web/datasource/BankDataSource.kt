package com.oatmusic.oat_music_server.web.datasource

import com.oatmusic.oat_music_server.web.model.Bank

interface BankDataSource {

    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
    fun saveBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
}