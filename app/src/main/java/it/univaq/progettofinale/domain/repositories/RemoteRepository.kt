package it.univaq.progettofinale.domain.repositories

import it.univaq.progettofinale.domain.model.User

interface RemoteRepository {

    suspend fun downloadData(): List<User>
}
