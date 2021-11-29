package com.qli38.qli38_p3.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.database.Player
import com.qli38.qli38_p3.databinding.FragmentDetailBinding
import com.qli38.qli38_p3.model.LevelModel
import com.qli38.qli38_p3.model.PlayerViewModel


class DetailFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val levelList = ArrayList<LevelModel>()
    private lateinit var addBtnDetail: Button
    private lateinit var startBtnDetail: Button
    private val playerAdapter = PlayerAdapter()
    private var playerInfo: Player? = playerAdapter.playerInfo
    private val sharedViewModel: PlayerViewModel by activityViewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        binding.addBtnDetail.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailFragment_to_dataEntryFragment32)
        }

        recycler = view.findViewById(R.id.recycler_view)
        recycler.layoutManager = LinearLayoutManager(context)

        addBtnDetail = view.findViewById(R.id.add_btn_detail)
        addBtnDetail.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailFragment_to_dataEntryFragment32)
        }
        startBtnDetail = view.findViewById(R.id.gameStart_detail)
        startBtnDetail.setOnClickListener {
            it.findNavController().navigate(R.id.action_detailFragment_to_detail2Fragment)
        }
        recycler.run {
            layoutManager = LinearLayoutManager(context)
            adapter = playerAdapter
        }


        return view
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        sharedViewModel.players.observe(viewLifecycleOwner, {
            playerAdapter.updatePlayers(it)
        })
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