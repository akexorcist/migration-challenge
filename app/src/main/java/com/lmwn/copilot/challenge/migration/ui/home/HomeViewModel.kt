package com.lmwn.copilot.challenge.migration.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lmwn.copilot.challenge.migration.data.DataRepository
import com.lmwn.copilot.challenge.migration.data.LocalDataRepository
import com.lmwn.copilot.challenge.migration.data.User
import kotlinx.coroutines.launch

enum class DataType {
    USERS, PRODUCTS, NEWS, STATISTICS
}

class HomeViewModel(private val repository: DataRepository = LocalDataRepository()) : ViewModel() {
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _products = MutableLiveData<List<String>>(emptyList())
    val products: LiveData<List<String>> = _products

    private val _news = MutableLiveData<List<String>>(emptyList())
    val news: LiveData<List<String>> = _news

    private val _statistics = MutableLiveData<List<String>>(emptyList())
    val statistics: LiveData<List<String>> = _statistics

    private val _users = MutableLiveData<List<User>>(emptyList())
    val users: LiveData<List<User>> = _users

    private val _errorMessage = MutableLiveData<String?>(null)
    val errorMessage: LiveData<String?> = _errorMessage

    private val _currentDataType = MutableLiveData(DataType.USERS)
    val currentDataType: LiveData<DataType> = _currentDataType

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        _currentDataType.postValue(DataType.USERS)
        _isLoading.postValue(true)
        _errorMessage.postValue(null)
        viewModelScope.launch {
            try {
                val users = repository.getUsers()
                _users.postValue(users)
                _products.postValue(emptyList())
                _news.postValue(emptyList())
                _statistics.postValue(emptyList())
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isLoading.postValue(false)
                _errorMessage.postValue(e.message ?: "Unknown error")
            }
        }
    }

    fun fetchProducts() {
        _currentDataType.postValue(DataType.PRODUCTS)
        _isLoading.postValue(true)
        _errorMessage.postValue(null)
        viewModelScope.launch {
            try {
                val products = repository.getProducts()
                _products.postValue(products)
                _users.postValue(emptyList())
                _news.postValue(emptyList())
                _statistics.postValue(emptyList())
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isLoading.postValue(false)
                _errorMessage.postValue(e.message ?: "Unknown error")
            }
        }
    }

    fun fetchNews() {
        _currentDataType.postValue(DataType.NEWS)
        _isLoading.postValue(true)
        _errorMessage.postValue(null)
        viewModelScope.launch {
            try {
                val news = repository.getNews()
                _news.postValue(news)
                _users.postValue(emptyList())
                _products.postValue(emptyList())
                _statistics.postValue(emptyList())
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isLoading.postValue(false)
                _errorMessage.postValue(e.message ?: "Unknown error")
            }
        }
    }

    fun fetchStatistics() {
        _currentDataType.postValue(DataType.STATISTICS)
        _isLoading.postValue(true)
        _errorMessage.postValue(null)
        viewModelScope.launch {
            try {
                val statistics = repository.getStatistics()
                _statistics.postValue(statistics)
                _users.postValue(emptyList())
                _products.postValue(emptyList())
                _news.postValue(emptyList())
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isLoading.postValue(false)
                _errorMessage.postValue(e.message ?: "Unknown error")
            }
        }
    }
}
