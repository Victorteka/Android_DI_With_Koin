package victorteka.github.io.koin_tutorial.data.repository

import victorteka.github.io.koin_tutorial.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() = apiHelper.getUsers()
}