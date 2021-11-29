package com.qli38.qli38_p3.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.preference.PreferenceManager
import com.qli38.qli38_p3.MainActivity.Companion.EFFECT_SELECTION
import com.qli38.qli38_p3.MainActivity.Companion.SHOW_HIDDEN_IMAGE
import com.qli38.qli38_p3.R
import com.qli38.qli38_p3.databinding.MainFragmentBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import jp.wasabeef.picasso.transformations.CropSquareTransformation

class MainFragment : Fragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var mainImageView: ImageView
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var welcomeBtn: Button
    private lateinit var settingBtn: Button
    private val prefs: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(activity)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        mainImageView = view.findViewById(R.id.welcome)
        prefs.registerOnSharedPreferenceChangeListener(this)

        // Inflate the layout for this fragment

//        binding.welcomeSettingBtn.setOnClickListener{
//            it.findNavController().navigate(R.id.action_mainFragment_to_settingFragment)
//        }
//
//        binding.welcomeStartGame.setOnClickListener{
////            gameStartAlert()
//            it.findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
//        }
        welcomeBtn = view.findViewById(R.id.welcome_startGame)
        welcomeBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }

        settingBtn = view.findViewById(R.id.welcome_setting_btn)
        settingBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_mainFragment_to_settingFragment)
        }


        return view;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        when (key) {
            SHOW_HIDDEN_IMAGE, EFFECT_SELECTION -> {
                setImage()
            }
        }
    }

    private fun setImage() {

        val effect = when (prefs.getString(EFFECT_SELECTION, "0")?.toInt()) {
            0 -> CropSquareTransformation()
            else -> CropCircleTransformation()

        }

        val resID = if (prefs.getBoolean(
                        SHOW_HIDDEN_IMAGE,
                        false
                )
        ) R.drawable.donkey else R.drawable.welcome_pic

        val picasso = Picasso.get()
        picasso.load(resID)
                .transform(effect)
                .into(mainImageView)
    }

}