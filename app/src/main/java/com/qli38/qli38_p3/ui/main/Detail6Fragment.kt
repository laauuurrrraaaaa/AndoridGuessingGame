package com.qli38.qli38_p3.ui.main

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.databinding.FragmentDetail5Binding
import com.qli38.qli38_p3.databinding.FragmentDetail6Binding

class Detail6Fragment : Fragment() {

    private var _binding: FragmentDetail6Binding? = null
    private val binding get() = _binding!!
    private var score = 0
    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetail6Binding.inflate(inflater, container, false)

        binding.answer1Detail6.setOnClickListener {
            Toast.makeText(activity, "NOPE, TRY SETTING", Toast.LENGTH_SHORT).show()
        }

        binding.answer2Detail6.setOnClickListener {
            score = 0
            it.findNavController().navigate(R.id.action_detail6Fragment_to_resultFragment)
        }

        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}