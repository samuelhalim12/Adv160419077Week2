package com.ubaya.adv160419077week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_in_game.*
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [InGameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InGameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var point = 0
        var rand = (0..99).random()
        var rand2 = (0..99).random()
        textNum1.setText(rand.toString())
        textNum2.setText(rand2.toString())

        buttonSubmit.setOnClickListener {
            if((rand+rand2).toString() == editAnswer.text.toString()) {
                Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                point++
                rand = (0..99).random()
                rand2 = (0..99).random()
                textNum1.setText(rand.toString())
                textNum2.setText(rand2.toString())
            } else {
                Toast.makeText(context, "Wrong Answer!", Toast.LENGTH_SHORT).show()
                val action = InGameFragmentDirections.actionResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}