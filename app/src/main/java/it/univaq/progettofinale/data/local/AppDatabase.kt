package it.univaq.progettofinale.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import it.univaq.progettofinale.data.local.dao.UserDao
import it.univaq.progettofinale.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
