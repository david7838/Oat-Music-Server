package com.oatmusic.oat_music_server.web.service

import com.oatmusic.oat_music_server.web.datasource.BankDataSource
import com.oatmusic.oat_music_server.web.model.Bank
import org.springframework.stereotype.Service

@Service
class BankService (private val bankDataSource: BankDataSource){

    fun getBanks(): Collection<Bank> = this.bankDataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank {
        return this.bankDataSource.retrieveBank(accountNumber)
    }

    fun postBank(bank: Bank): Bank {
        return this.bankDataSource.saveBank(bank)
    }

    fun patchBank(bank: Bank): Bank {
        return this.bankDataSource.updateBank(bank)
    }
}