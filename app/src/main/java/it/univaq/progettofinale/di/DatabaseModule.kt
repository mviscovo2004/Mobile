package it.univaq.progettofinale.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.univaq.progettofinale.data.local.AppDatabase
import it.univaq.progettofinale.data.local.RoomLocalRepository
import it.univaq.progettofinale.domain.repositories.LocalRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides @Singleton fun provideUserDao(db: AppDatabase) = db.userDao()
}

abstract class DatabaseRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLocalRepository(roomLocalRepository: RoomLocalRepository): LocalRepository
}
