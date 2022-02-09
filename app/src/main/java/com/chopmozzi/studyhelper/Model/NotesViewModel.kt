package com.chopmozzi.studyhelper.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val repository:NotesRepository

    init{
        val dao=NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository=NotesRepository(dao)
    }
    fun addNotes(notes: Notes)
    {
        repository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()

    fun getCheckNotes(check:String): LiveData<List<Notes>> = repository.getCheckNotes(check)


    fun deleteNotes(id:Int)
    {
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes)
    {
        repository.updateNotes(notes)
    }

    fun getSubTitle() : LiveData<List<String>> = repository.getSubTitle()

}