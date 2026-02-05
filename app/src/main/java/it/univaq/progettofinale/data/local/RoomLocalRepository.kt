package it.univaq.progettofinale.data.local

import it.univaq.progettofinale.data.local.dao.UserDao
import it.univaq.progettofinale.data.local.entities.UserEntity
import it.univaq.progettofinale.domain.model.User
import it.univaq.progettofinale.domain.repositories.LocalRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

private fun User.toEntity() =
        UserEntity(
                name = name,
                username = username,
                email = email,
                city = city,
                lat = lat,
                lng = lng
        )

private fun UserEntity.toDomain() =
        User(
                id = id,
                name = name,
                username = username,
                email = email,
                city = city,
                lat = lat,
                lng = lng
        )

class RoomLocalRepository @Inject constructor(private val userDao: UserDao) : LocalRepository {

    override suspend fun save(data: List<User>) {
        with(Dispatchers.IO) {
            clear()
            userDao.insertAll(data.map { it.toEntity() })
        }
    }

    override suspend fun getAll(): List<User> {
        return userDao.getAll().map { it.toDomain() }
    }

    override suspend fun clear() {
        userDao.clear()
    }
}
