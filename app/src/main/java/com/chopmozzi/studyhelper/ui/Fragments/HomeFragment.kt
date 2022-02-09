package com.chopmozzi.studyhelper.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chopmozzi.studyhelper.Model.NotesViewModel
import com.chopmozzi.studyhelper.R
import com.chopmozzi.studyhelper.databinding.FragmentHomeBinding
import com.chopmozzi.studyhelper.ui.Adapter.NotesAdapter
import com.chopmozzi.studyhelper.ui.Adapter.SubAdapter


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)


        viewModel.getSubTitle().observe(viewLifecycleOwner, {notesList->
            binding.rcvAllNote.layoutManager=GridLayoutManager(requireContext(),1)
            //binding.rcvAllNote.adapter=NotesAdapter(requireContext(), notesList)
            binding.rcvAllNote.adapter=SubAdapter(requireContext(),notesList)
        })
        /*viewModel.getNotes().observe(viewLifecycleOwner, {notesList ->
            binding.rcvAllNote.layoutManager=GridLayoutManager(requireContext(),1)
            binding.rcvAllNote.adapter=NotesAdapter(requireContext(),notesList)
        })*/
        /*viewModel.getCheckNotes("ddb").observe(viewLifecycleOwner,{notesList->
            binding.rcvAllNote.layoutManager=GridLayoutManager(requireContext(),1)
            binding.rcvAllNote.adapter=NotesAdapter(requireContext(),notesList)
        })*/
        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)

        }

        return binding.root
    }

}