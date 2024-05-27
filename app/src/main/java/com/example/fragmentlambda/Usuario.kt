package com.example.fragmentlambda

import java.io.Serializable
// userName, firstName, lastName, email, password, phone
data class Usuario(
    val userName: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phone: String
) : Serializable