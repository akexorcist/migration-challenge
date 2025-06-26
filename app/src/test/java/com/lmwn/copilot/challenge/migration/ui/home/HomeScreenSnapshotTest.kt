package com.lmwn.copilot.challenge.migration.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import com.lmwn.copilot.challenge.migration.data.FakeDataRepository
import com.lmwn.copilot.challenge.migration.data.User
import com.lmwn.copilot.challenge.migration.ui.theme.MigrationChallengeTheme
import kotlinx.coroutines.test.runTest
import org.junit.*

class HomeScreenSnapshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
        theme = "android:Theme.Material3.DayNight"
    )

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: FakeDataRepository
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        repository = FakeDataRepository()
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun homeScreen_initial_showsEmptyState() {
        repository.setEmptyData()

        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_users_showsUsersList() = runTest {
        val mockUsers = listOf(
            User(1, "👨‍💻 John Doe", "john.doe@company.com", "Engineering", true),
            User(2, "👩‍💼 Jane Smith", "jane.smith@company.com", "Marketing", true),
            User(3, "👨‍🔬 Bob Wilson", "bob.wilson@company.com", "Research", false),
            User(4, "👩‍🎨 Alice Brown", "alice.brown@company.com", "Design", true)
        )

        repository.usersData = mockUsers
        repository.productsData = emptyList()
        repository.newsData = emptyList()
        repository.statisticsData = emptyList()

        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_products_showsProductsList() = runTest {
        val mockProducts = listOf(
            "💻 MacBook Pro M3 - $2,499",
            "📱 iPhone 15 Pro - $1,199",
            "⌚ Apple Watch Series 9 - $399",
            "🎧 AirPods Pro - $249"
        )

        repository.usersData = emptyList()
        repository.productsData = mockProducts
        repository.newsData = emptyList()
        repository.statisticsData = emptyList()

        viewModel.fetchProducts()

        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_news_showsNewsList() = runTest {
        val mockNews = listOf(
            "🚀 SpaceX Successfully Launches New Satellite Mission",
            "💡 Breakthrough in Quantum Computing Achieved by Tech Giants",
            "🌍 Global Climate Summit Announces New Environmental Initiatives",
            "📈 Stock Market Reaches New All-Time High"
        )

        repository.usersData = emptyList()
        repository.productsData = emptyList()
        repository.newsData = mockNews
        repository.statisticsData = emptyList()

        viewModel.fetchNews()

        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_statistics_showsStatisticsList() = runTest {
        val mockStatistics = listOf(
            "💰 Monthly Revenue: $2,543,891",
            "👥 Active Users: 1,234,567",
            "📈 Growth Rate: +15.3%",
            "⭐ Customer Satisfaction: 94.7%"
        )

        repository.usersData = emptyList()
        repository.productsData = emptyList()
        repository.newsData = emptyList()
        repository.statisticsData = mockStatistics

        viewModel.fetchStatistics()

        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_error_showsErrorMessage() = runTest {
        repository.setError("Network connection failed")
        
        paparazzi.snapshot {
            MigrationChallengeTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }

    @Test
    fun homeScreen_userCard_showsUserDetails() {
        val user = User(
            id = 1,
            name = "👨‍💻 John Doe",
            email = "john.doe@company.com",
            department = "Engineering",
            isActive = true
        )

        paparazzi.snapshot {
            MigrationChallengeTheme {
                UserCard(user = user)
            }
        }
    }

    @Test
    fun homeScreen_userCard_inactiveUser() {
        val user = User(
            id = 2,
            name = "👩‍💼 Jane Smith",
            email = "jane.smith@company.com",
            department = "Marketing",
            isActive = false
        )

        paparazzi.snapshot {
            MigrationChallengeTheme {
                UserCard(user = user)
            }
        }
    }
} 
