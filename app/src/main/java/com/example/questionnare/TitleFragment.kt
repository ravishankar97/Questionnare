package com.example.questionnare


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.questionnare.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding:FragmentTitleBinding = FragmentTitleBinding.inflate(inflater,container,false)

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
        }

        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,findNavController())|| super.onOptionsItemSelected(item)
    }
}



