package com.example.testingprepopulateddb.data

import kotlinx.coroutines.flow.Flow


class Repository(private val dao: TestDao) {

    suspend fun getData(): Flow<List<Table>> {
        return dao.getAllData()
    }
}