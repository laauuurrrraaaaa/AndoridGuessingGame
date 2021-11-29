package com.qli38.qli38_p3.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.databinding.FragmentDetail2Binding
import com.qli38.qli38_p3.databinding.FragmentDetail3Binding


class Detail3Fragment : Fragment() {

    private var _binding: FragmentDetail3Binding? = null
    private val binding get() = _binding!!
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetail3Binding.inflate(inflater, container, false)

        binding.answer1Detail3.setOnClickListener {
            Toast.makeText(activity, "NOPE", Toast.LENGTH_SHORT).show()
        }

        binding.answer4Detail3.setOnClickListener {
            score = 2
            it.findNavController().navigate(R.id.action_detail3Fragment_to_detail4Fragment)
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