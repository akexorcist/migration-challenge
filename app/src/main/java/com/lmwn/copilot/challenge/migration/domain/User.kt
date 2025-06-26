package com.lmwn.copilot.challenge.migration.domain

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val department: String,
    val isActive: Boolean
) 