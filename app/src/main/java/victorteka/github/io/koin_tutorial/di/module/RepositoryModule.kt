package victorteka.github.io.koin_tutorial.di.module

import org.koin.dsl.module
import victorteka.github.io.koin_tutorial.data.api.ApiHelper
import victorteka.github.io.koin_tutorial.data.api.ApiHelperImpl
import victorteka.github.io.koin_tutorial.data.repository.MainRepository


val repoModule = module {
    single { MainRepository(get()) }
    single <ApiHelper>{
        return@single ApiHelperImpl(get())
    }
}