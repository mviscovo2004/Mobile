package it.univaq.progettofinale.domain.repositories

import it.univaq.progettofinale.domain.model.User

interface LocalRepository {
    suspend fun save(data: List<User>)

    suspend fun getAll(): List<User>

    suspend fun clear()
}
