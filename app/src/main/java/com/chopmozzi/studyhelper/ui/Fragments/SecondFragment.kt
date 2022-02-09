package com.chopmozzi.studyhelper.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.chopmozzi.studyhelper.Model.NotesViewModel
import com.chopmozzi.studyhelper.R
import com.chopmozzi.studyhelper.databinding.FragmentHomeBinding
import com.chopmozzi.studyhelper.ui.Adapter.NotesAdapter
import com.chopmozzi.studyhelper.ui.Adapter.SubAdapter


class SecondFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()
    val oldSubject by navArgs<SecondFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)

        viewModel.getCheckNotes(oldSubject.subject).observe(viewLifecycleOwner, {notesList->
            binding.rcvAllNote.layoutManager= GridLayoutManager(requireContext(),1)
            //binding.rcvAllNote.adapter=NotesAdapter(requireContext(), notesList)
            binding.rcvAllNote.adapter= NotesAdapter(requireContext(),notesList)
        })


        return binding.root
    }


}