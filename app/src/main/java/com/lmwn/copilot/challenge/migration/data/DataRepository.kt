package com.lmwn.copilot.challenge.migration.data

interface DataRepository {
    suspend fun getUsers(): List<User>
    suspend fun getProducts(): List<String>
    suspend fun getNews(): List<String>
    suspend fun getStatistics(): List<String>
}
