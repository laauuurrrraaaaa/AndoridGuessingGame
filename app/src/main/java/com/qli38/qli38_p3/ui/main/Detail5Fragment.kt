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
import com.qli38.qli38_p3.databinding.FragmentDetail4Binding
import com.qli38.qli38_p3.databinding.FragmentDetail5Binding

class Detail5Fragment : Fragment() {

    private var _binding: FragmentDetail5Binding? = null
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
        _binding = FragmentDetail5Binding.inflate(inflater, container, false)
        animateGraph1()

        binding.answer1Detail5.setOnClickListener {
            Toast.makeText(activity, "NOPE", Toast.LENGTH_SHORT).show()
        }

        binding.answer2Detail5.setOnClickListener {
            score = 0
            it.findNavController().navigate(R.id.action_detail5Fragment_to_detail6Fragment)
        }

        return binding.root
    }

    private fun animateGraph1(){

        val buttonAnimator1 = ObjectAnimator.ofFloat(
            binding.imageView5,
            "translationY",
            1500f,
            -1100f
        )

        buttonAnimator1.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {}
        })

        val set = AnimatorSet()
        set.play(buttonAnimator1)
        set.duration = 700L
        set.start()


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