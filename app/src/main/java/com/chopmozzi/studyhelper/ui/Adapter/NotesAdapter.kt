package com.chopmozzi.studyhelper.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.chopmozzi.studyhelper.Model.Notes
import com.chopmozzi.studyhelper.databinding.ActivityMainBinding
import com.chopmozzi.studyhelper.ui.Fragments.HomeFragment
import com.chopmozzi.studyhelper.ui.Fragments.HomeFragmentDirections
import com.chopmozzi.studyhelper.databinding.ItemNotesBinding


class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
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
    var fragment1 = HomeFragment()


    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data =notesList[position]
        //val checkTitle=holder.binding.notesSubTitle.toString()

        holder.binding.notesTitle.text=notesList[position].title
        holder.binding.notesSubTitle.text=data.subTitle

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)
            //Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_editNotesFragment)
        }
    }

    override fun getItemCount() = notesList.size

}