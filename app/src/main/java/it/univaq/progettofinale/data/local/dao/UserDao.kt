package it.univaq.progettofinale.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import it.univaq.progettofinale.data.local.entities.UserEntity

@Dao
interface UserDao {
    @Upsert suspend fun insert(user: UserEntity)

    @Upsert suspend fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM users") suspend fun getAll(): List<UserEntity>

    @Query("DELETE FROM users") suspend fun clear()

    @Delete suspend fun delete(user: UserEntity)
}
