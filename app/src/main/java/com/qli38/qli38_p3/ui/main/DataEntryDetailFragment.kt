package com.qli38.qli38_p3.ui.main

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.database.Player
import com.qli38.qli38_p3.databinding.FragmentDataEntryDetailBinding
import com.qli38.qli38_p3.model.PlayerViewModel

class DataEntryFragment : Fragment() {

    private val sharedViewModel: PlayerViewModel by activityViewModels()
    private var binding: FragmentDataEntryDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataEntryBinding = FragmentDataEntryDetailBinding.inflate(inflater, container, false)
        binding = dataEntryBinding
        binding?.apply {
            addBtn.setOnClickListener {
                val player = Player()
                player.firstName = editTextFirstName.text.toString()
                player.lastName = editTextLastName.text.toString()
                player.nickName = editTextNickname.text.toString()
                player.comment = editTextComment.text.toString()

                sharedViewModel.insert(player)
                itemAddedAlert(player)

                findNavController().navigate(R.id.action_dataEntryFragment3_to_detailFragment)
                context?.hideKeyboard(it)
            }
            cancelBtn.setOnClickListener{
                findNavController().navigate(R.id.action_dataEntryFragment3_to_detailFragment)
            }
        }
        return dataEntryBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun itemAddedAlert(player:Player) {
        val msg = resources.getString(R.string.player_add_alter, player.firstName)
        val builder = AlertDialog.Builder(context)
        with(builder) {
            setTitle(R.string.confirm)
            setMessage(msg)
            setPositiveButton(R.string.yes, null)
            show()
        }
    }
}

fun Context.hideKeyboard(view: View) {
    val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}