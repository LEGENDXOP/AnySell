package com.legendx.anysell.utils

import android.content.Context
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.models.InputFile
import io.appwrite.models.Session
import io.appwrite.models.User
import io.appwrite.services.Account
import io.appwrite.services.Storage


object Appwrite {
    private lateinit var client: Client
    lateinit var account: Account
    lateinit var storage: Storage

    fun init(context: Context) {
        client = Client(context)
            .setEndpoint("https://cloud.appwrite.io/v1")
            .setProject("67dbe16c001526df065f")
        account = Account(client)
        storage = Storage(client)
    }

    suspend fun registerAccount(email: String, password: String): User<Map<String, Any>> {
        val userAcc = account.create(
            userId = ID.unique(),
            email,
            password
        )
        account.createEmailPasswordSession(email, password)
        return userAcc
    }

    suspend fun loginAccount(email: String, password: String): Session {
        return account.createEmailPasswordSession(email, password)
    }

    suspend fun logoutAccount() {
        account.deleteSession("current")
    }

    suspend fun uploadFile(file: InputFile): String {
        val fileUpload = storage.createFile(
            bucketId = "67f950700031fa8ce6d5",
            fileId = ID.unique(),
            file = file
        )
        return fileUpload.id
    }

    suspend fun downloadFile(fileID: String): ByteArray {
        val result = storage.getFileDownload(
            bucketId = "67f950700031fa8ce6d5",
            fileId = fileID
        )
        return result
    }

    fun getFileURL(fileId: String): String {
        return "https://cloud.appwrite.io/v1/storage/buckets/67f950700031fa8ce6d5/files/$fileId/view?project=67dbe16c001526df065f"
    }

}