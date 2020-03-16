package com.example.questionnare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.questionnare.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 */
class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val bindingGameOver:FragmentGameOverBinding = FragmentGameOverBinding.inflate(inflater,container,false)

        bindingGameOver.tryAgainBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }
        return bindingGameOver.root
    }

}
