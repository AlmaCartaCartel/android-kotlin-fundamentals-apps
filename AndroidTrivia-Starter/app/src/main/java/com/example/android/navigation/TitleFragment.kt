package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_title, container, false)

        setOnClickPlayButton()
        setOnClickRulesButton()
        setOnClickAboutButton()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }

    private fun setOnClickRulesButton(){
        binding.rulesButton.setOnClickListener { view: View ->
            view.findNavController()
                    .navigate(R.id.rulesFragment)
        }
    }

    private fun setOnClickPlayButton(){
        binding.playButton.setOnClickListener { view: View ->
            view.findNavController()
                    .navigate(R.id.action_titleFragment2_to_gameFragment)
        }
    }

    private fun setOnClickAboutButton(){
        binding.aboutButton.setOnClickListener { view: View ->
            view.findNavController()
                    .navigate(R.id.aboutFragment)
        }
    }
}
