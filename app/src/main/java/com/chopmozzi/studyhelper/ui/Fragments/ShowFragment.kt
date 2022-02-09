package com.chopmozzi.studyhelper.ui.Fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.chopmozzi.studyhelper.Model.Notes
import com.chopmozzi.studyhelper.Model.NotesViewModel
import com.chopmozzi.studyhelper.R
import com.chopmozzi.studyhelper.databinding.FragmentEditNotesBinding
import com.chopmozzi.studyhelper.databinding.FragmentShowBinding


class ShowFragment : Fragment() {

    val viewModel: NotesViewModel by viewModels()
    val oldNotes by navArgs<ShowFragmentArgs>()
    lateinit var binding: FragmentShowBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShowBinding.inflate(layoutInflater, container, false)

        binding.shwTitle.text=oldNotes.data.title
        binding.shwSubTitle.text=oldNotes.data.subTitle
        binding.shwNotes.text=oldNotes.data.notes

        /*binding.btnTesNotes.setOnClickListener {

        }*/
        binding.btnUpdNotes.setOnClickListener {

            val action = ShowFragmentDirections.actionShowFragmentToEditNotesFragment(oldNotes.data)
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }


}