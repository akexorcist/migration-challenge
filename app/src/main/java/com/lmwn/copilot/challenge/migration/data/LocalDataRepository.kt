package com.lmwn.copilot.challenge.migration.data

import kotlin.random.Random
import kotlinx.coroutines.delay

class LocalDataRepository : DataRepository {

    override suspend fun getUsers(): List<User> {
        delay(1500) // Simulate network delay
        return listOf(
            User(1, "👨‍💻 John Doe", "john.doe@company.com", "Engineering", true),
            User(2, "👩‍💼 Jane Smith", "jane.smith@company.com", "Marketing", true),
            User(3, "👨‍🎨 Mike Johnson", "mike.johnson@company.com", "Design", false),
            User(4, "👩‍🔬 Sarah Wilson", "sarah.wilson@company.com", "Research", true),
            User(5, "👨‍💼 David Brown", "david.brown@company.com", "Sales", true),
            User(6, "👩‍🏫 Lisa Davis", "lisa.davis@company.com", "Training", false),
            User(7, "👨‍🔧 Tom Miller", "tom.miller@company.com", "Support", true),
            User(8, "👩‍⚕️ Emma Garcia", "emma.garcia@company.com", "Health", true),
            User(9, "👨‍🍳 Chris Martinez", "chris.martinez@company.com", "Operations", false),
            User(10, "👩‍🎤 Amy Taylor", "amy.taylor@company.com", "Communications", true)
        )
    }

    override suspend fun getProducts(): List<String> {
        delay(1200) // Simulate network delay
        return listOf(
            "💻 MacBook Pro M3 - $2,499",
            "📱 iPhone 15 Pro - $1,199",
            "⌚ Apple Watch Series 9 - $399",
            "🎧 AirPods Pro 2 - $249",
            "📺 Samsung 55\" OLED TV - $1,299",
            "🎮 PlayStation 5 - $499",
            "📷 Canon EOS R5 - $3,899",
            "💾 Samsung 2TB SSD - $199",
            "🖥️ Dell UltraSharp Monitor - $599",
            "⌨️ Mechanical Keyboard - $159"
        )
    }

    override suspend fun getNews(): List<String> {
        delay(1000) // Simulate network delay
        return listOf(
            "🚀 SpaceX Successfully Launches New Satellite Mission",
            "💡 Breakthrough in Quantum Computing Achieved by Tech Giants",
            "🌱 New Renewable Energy Project Reduces Carbon Emissions by 40%",
            "🏥 Revolutionary Gene Therapy Shows Promise in Clinical Trials",
            "🤖 AI Assistant Helps Doctors Diagnose Rare Diseases",
            "🌍 Global Climate Summit Reaches Historic Agreement",
            "📊 Stock Market Reaches All-Time High Amid Tech Rally",
            "🎓 University Develops New Method for Ocean Plastic Cleanup",
            "🚗 Electric Vehicle Sales Surpass Traditional Cars for First Time",
            "🔬 Scientists Discover New Species in Deep Ocean Exploration"
        )
    }

    override suspend fun getStatistics(): List<String> {
        delay(800) // Simulate network delay
        val revenue = Random.nextInt(50000, 150000)
        val users = Random.nextInt(10000, 50000)
        val growth = Random.nextDouble(5.0, 25.0)
        val satisfaction = Random.nextDouble(85.0, 98.0)

        return listOf(
            "💰 Monthly Revenue: ${String.format("$%,d", revenue)}",
            "👥 Active Users: ${String.format("%,d", users)}",
            "📈 Growth Rate: ${String.format("%.1f%%", growth)}",
            "⭐ Customer Satisfaction: ${String.format("%.1f%%", satisfaction)}",
            "🎯 Conversion Rate: ${String.format("%.2f%%", Random.nextDouble(2.0, 8.0))}",
            "⏱️ Avg. Response Time: ${Random.nextInt(50, 200)}ms",
            "🔄 Return Customers: ${String.format("%.1f%%", Random.nextDouble(60.0, 85.0))}",
            "📱 Mobile Users: ${String.format("%.1f%%", Random.nextDouble(65.0, 80.0))}",
            "🌐 Global Reach: ${Random.nextInt(25, 50)} countries",
            "💬 Support Tickets: ${Random.nextInt(100, 500)} resolved"
        )
    }
}
