package com.example.questionnare

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.fragment.findNavController
import com.example.questionnare.databinding.FragmentGameWonBinding

/**
 * A simple [Fragment] subclass.
 */
class GameWonFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val bindingGameWon:FragmentGameWonBinding = FragmentGameWonBinding.inflate(inflater,container,false)

        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(context,"Number of QuestionS ${args?.numQuestions}, Number of Answers ${args?.numCorrect}",Toast.LENGTH_LONG).show()

        bindingGameWon.reMatchBtn.setOnClickListener {
            findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }
        setHasOptionsMenu(true)
        return bindingGameWon.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.game_share_menu,menu)


        if(null == getShareIntent()?.resolveActivity(activity!!.packageManager)){
            menu.findItem(R.id.share)?.isVisible = false
        }

    }

    private fun getShareIntent(): Intent? {
        val args = GameWonFragmentArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain")
//            .putExtra(Intent.EXTRA_TEXT,
//                getString(R.string.share_success_text,args.numCorrect,args.numQuestions))


        return ShareCompat.IntentBuilder.from(activity!!)
                .setText(getString(R.string.share_success_text,args.numCorrect,args.numQuestions))
                .setType("text/plain")
                .intent
        }




    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.share ->shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}
