package com.legendx.anysell.utils

import android.content.Context
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.models.Session
import io.appwrite.models.User
import io.appwrite.services.Account

object Appwrite {
    private lateinit var client: Client
    lateinit var account: Account

    fun init(context: Context){
        client = Client(context)
            .setEndpoint("https://cloud.appwrite.io/v1")
            .setProject("67dbe16c001526df065f")
        account = Account(client)
    }

    suspend fun registerAccount(email: String, password: String): User<Map<String, Any>>{
        val userAcc = account.create(
            userId = ID.unique(),
            email,
            password
        )
        account.createEmailPasswordSession(email, password)
        return userAcc
    }

    suspend fun loginAccount(email: String, password: String): Session{
        return account.createEmailPasswordSession(email, password)
    }

    suspend fun logoutAccount(){
        account.deleteSession("current")
    }
}