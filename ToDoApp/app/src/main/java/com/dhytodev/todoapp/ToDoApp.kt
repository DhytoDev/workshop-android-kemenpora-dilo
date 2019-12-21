package com.dhytodev.todoapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by DhytoDev on 2019-12-21.
 * Email : dhytodev@gmail.com
 */
class ToDoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ToDoApp)
            modules(taskModule)
        }
    }
}