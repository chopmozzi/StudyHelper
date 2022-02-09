package com.chopmozzi.studyhelper.Model

import androidx.lifecycle.LiveData

class NotesRepository(val dao: NotesDao) {
    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }

    fun getCheckNotes(check: String): LiveData<List<Notes>> {
        return dao.getCheckNotes(check)
    }

    fun getSubTitle(): LiveData<List<String>> {
        return dao.getSubTitles()

    }
}
