package com.chopmozzi.studyhelper.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Notes")
class Notes (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    @ColumnInfo
    var subTitle: String,
    var notes: String

) : Parcelable