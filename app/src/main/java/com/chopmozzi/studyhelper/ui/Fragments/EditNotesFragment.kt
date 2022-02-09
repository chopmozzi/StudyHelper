package com.chopmozzi.studyhelper.ui.Fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.chopmozzi.studyhelper.Model.Notes
import com.chopmozzi.studyhelper.Model.NotesViewModel
import com.chopmozzi.studyhelper.R
import com.chopmozzi.studyhelper.databinding.FragmentEditNotesBinding


class EditNotesFragment : Fragment() {
    val viewModel: NotesViewModel by viewModels()
    val oldNotes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_edit_notes, container, false)
        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)
        /*viewModel.getNotes().observe(viewLifecycleOwner, {notesList ->
            binding.editNotes.
            binding.rcvAllNote.adapter= NotesAdapter(requireContext(),notesList)
        })*/
        //binding.edtTitle.setText(viewModel.getNotes().)
        //setHasOptionsMenu(true)
        binding.edtTitle.setText(oldNotes.data.title)
        binding.edtSubTitle.setText(oldNotes.data.subTitle)
        binding.edtNotes.setText(oldNotes.data.notes)


        binding.btnEditNotes.setOnClickListener {
            updateNotes(it)
        }

        binding.btnDelNotes.setOnClickListener {
            deleteNotes(it)
        }
        return binding.root
    }

    private fun deleteNotes(it: View?) {
        viewModel.deleteNotes(oldNotes.data.id!!)
        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }

    private fun updateNotes(it: View?) {
        val title=binding.edtTitle.text.toString()
        val subTitle = binding.edtSubTitle.text.toString()
        val notes = binding.edtNotes.text.toString()
        val data = Notes(
            oldNotes.data.id,
            title = title,
            subTitle = subTitle,
            notes = notes,

            )
        viewModel.updateNotes(data)

        Toast.makeText(requireContext(), "Notes Updated Successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.menu_delete)
        {

            viewModel.deleteNotes(oldNotes.data.id!!)
            //Navigation.findNavController(this.requireView()).navigate(R.id.action_editNotesFragment_to_homeFragment)
            //viewModel.findNavController().navigate(R.id.action_editNotesFragment_to_homeFragment)
            //Navigation.findNavController(binding.root).navigate(R.id.action_editNotesFragment_to_homeFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}