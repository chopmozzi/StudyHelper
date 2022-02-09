package com.chopmozzi.studyhelper.Model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)

    @Query("SELECT * FROM Notes WHERE subTitle=:check")
    fun getCheckNotes(check:String): LiveData<List<Notes>>

    @Query("SELECT DISTINCT subTitle FROM Notes /*WHERE subTitle*/")
    fun getSubTitles(): LiveData<List<String>>
}