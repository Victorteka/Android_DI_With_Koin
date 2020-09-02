package victorteka.github.io.koin_tutorial.data.api

import retrofit2.Response
import retrofit2.http.GET
import victorteka.github.io.koin_tutorial.data.models.User

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}