package victorteka.github.io.koin_tutorial.data.api

import retrofit2.Response
import victorteka.github.io.koin_tutorial.data.models.User

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers(): Response<List<User>> {
        return  apiService.getUsers()
    }
}