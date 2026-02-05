package it.univaq.progettofinale.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.univaq.progettofinale.data.remote.RetrofitRemoteRepository
import it.univaq.progettofinale.data.remote.service.EndPointService
import it.univaq.progettofinale.domain.repositories.RemoteRepository
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideClient() =
            Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

    @Provides @Singleton fun service(client: Retrofit) = client.create(EndPointService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(remoteRepository: RetrofitRemoteRepository): RemoteRepository
}
