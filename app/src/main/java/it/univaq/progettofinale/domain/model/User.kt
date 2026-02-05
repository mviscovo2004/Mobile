package it.univaq.progettofinale.domain.model

data class User(
        val id: Long? = null,
        val name: String,
        val username: String,
        val email: String,
        val city: String,
        val lat: Double,
        val lng: Double
)
