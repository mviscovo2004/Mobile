package it.univaq.progettofinale.data.remote.service

import it.univaq.progettofinale.data.remote.model.RemoteUser
import retrofit2.http.GET

interface EndPointService {
    @GET("users") suspend fun users(): List<RemoteUser>
}
