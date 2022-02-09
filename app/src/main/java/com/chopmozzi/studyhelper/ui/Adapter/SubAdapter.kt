package com.chopmozzi.studyhelper.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chopmozzi.studyhelper.databinding.ItemNotesBinding

class SubAdapter(val requireContext: Context, val notesList: List<String>) : RecyclerView.Adapter<SubAdapter.notesViewHolder>() {
    class notesViewHolder(val binding: ItemNotesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        //val data =notesList[position]
        //val checkTitle=holder.binding.notesSubTitle.toString()
        holder.binding.notesTitle.text=notesList[position]
        //holder.binding.notesTitle.text=notesList[position].title
        //holder.binding.notesSubTitle.text=data.subTitle
    }

    override fun getItemCount() = notesList.size

}