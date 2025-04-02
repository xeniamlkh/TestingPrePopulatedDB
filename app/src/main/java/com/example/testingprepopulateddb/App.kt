package com.example.testingprepopulateddb

import android.app.Application
import com.example.testingprepopulateddb.data.Repository
import com.example.testingprepopulateddb.data.TestDatabase

class App : Application() {
    val database: TestDatabase by lazy { TestDatabase.getDatabase(this) }
    val repository: Repository by lazy { Repository(database.dao()) }
}