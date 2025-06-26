package com.lmwn.copilot.challenge.migration.data

import kotlinx.coroutines.delay

class FakeDataRepository : DataRepository {

    // Control flags for testing different scenarios
    var shouldThrowError = false
    var errorMessage = "Test error"
    var delayMs = 100L // Short delay for testing

    // Data to return
    var usersData: List<User> = getDefaultUsers()
    var productsData: List<String> = getDefaultProducts()
    var newsData: List<String> = getDefaultNews()
    var statisticsData: List<String> = getDefaultStatistics()
    var genericData: List<String> = listOf("Item 1", "Item 2", "Item 3")

    override suspend fun getUsers(): List<User> {
        if (shouldThrowError) throw Exception(errorMessage)
        return usersData
    }

    override suspend fun getProducts(): List<String> {
        if (shouldThrowError) throw Exception(errorMessage)
        return productsData
    }

    override suspend fun getNews(): List<String> {
        if (shouldThrowError) throw Exception(errorMessage)
        return newsData
    }

    override suspend fun getStatistics(): List<String> {
        if (shouldThrowError) throw Exception(errorMessage)
        return statisticsData
    }

    // Helper methods to reset test data
    fun reset() {
        shouldThrowError = false
        errorMessage = "Test error"
        delayMs = 100L
        usersData = getDefaultUsers()
        productsData = getDefaultProducts()
        newsData = getDefaultNews()
        statisticsData = getDefaultStatistics()
        genericData = listOf("Item 1", "Item 2", "Item 3")
    }

    fun setError(message: String) {
        shouldThrowError = true
        errorMessage = message
    }

    fun setEmptyData() {
        usersData = emptyList()
        productsData = emptyList()
        newsData = emptyList()
        statisticsData = emptyList()
        genericData = emptyList()
    }

    companion object {
        fun getDefaultUsers(): List<User> = listOf(
            User(1, "👨‍💻 John Doe", "john.doe@company.com", "Engineering", true),
            User(2, "👩‍💼 Jane Smith", "jane.smith@company.com", "Marketing", true),
            User(3, "👩‍🎨 Mike Johnson", "mike.johnson@company.com", "Design", false)
        )

        fun getDefaultProducts(): List<String> = listOf(
            "💻 MacBook Pro M3 - $2,499",
            "📱 iPhone 15 Pro - $1,199",
            "⌚ Apple Watch Series 9 - $399"
        )

        fun getDefaultNews(): List<String> = listOf(
            "🚀 SpaceX Successfully Launches New Satellite Mission",
            "💡 Breakthrough in Quantum Computing Achieved by Tech Giants",
            "🌱 New Renewable Energy Project Reduces Carbon Emissions by 40%"
        )

        fun getDefaultStatistics(): List<String> = listOf(
            "💰 Monthly Revenue: $75,000",
            "👥 Active Users: 25,000",
            "📈 Growth Rate: 15.5%"
        )
    }
} 
