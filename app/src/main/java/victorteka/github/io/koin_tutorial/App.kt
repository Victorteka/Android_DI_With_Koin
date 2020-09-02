package victorteka.github.io.koin_tutorial

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import victorteka.github.io.koin_tutorial.di.module.appModule
import victorteka.github.io.koin_tutorial.di.module.repoModule
import victorteka.github.io.koin_tutorial.di.module.viewModelModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}