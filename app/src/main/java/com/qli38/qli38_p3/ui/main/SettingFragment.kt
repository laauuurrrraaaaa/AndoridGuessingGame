package com.qli38.qli38_p3.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.preference.PreferenceFragmentCompat
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.databinding.FragmentSettingBinding



class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setHasOptionsMenu(true)
        setPreferencesFromResource(R.xml.preference_screen, rootKey)
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

}