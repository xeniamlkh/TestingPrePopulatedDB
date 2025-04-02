package com.example.testingprepopulateddb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class Table(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "Column_1") val column1: Double,
    @ColumnInfo(name = "Column_2") val column2: Double,
    @ColumnInfo(name = "Column_3") val column3: Double,
    @ColumnInfo(name = "Column_4") val column4: Double,
    @ColumnInfo(name = "Column_5") val column5: Double,
    @ColumnInfo(name = "Column_6") val column6: Double,
    @ColumnInfo(name = "Column_7") val column7: Double,
    @ColumnInfo(name = "Column_8") val column8: Double,
    @ColumnInfo(name = "Column_9") val column9: Double,
    @ColumnInfo(name = "Column_10") val column10: Double,
)
