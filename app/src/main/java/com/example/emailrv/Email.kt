package com.example.emailrv

data class Email (
    val username: String,
    val message: String,
    val avatar: String,
    val time: String,
    var selected: Boolean,
)