package victorteka.github.io.koin_tutorial.di.module

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import victorteka.github.io.koin_tutorial.ui.main.viewmodel.MainViewModel

val viewModelModule = module {
    viewModel {
        MainViewModel(get(), get())
    }
}