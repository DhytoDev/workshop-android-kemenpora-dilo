package com.dhytodev.todoapp

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by DhytoDev on 2019-12-21.
 * Email : dhytodev@gmail.com
 */

val taskModule = module {
    single { TaskDatabase.getInstance(androidContext()) }
    viewModel { TaskViewModel(get()) }
}