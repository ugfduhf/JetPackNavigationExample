package com.saif.jetpacknavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment(R.layout.fragment_settings) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_default_amount.setText(sampleData.defaultAmount.value.toString())

        btn_default_amount.setOnClickListener {
            val defaultAmount = et_default_amount.text.toString().toLong()
            sampleData.defaultAmount.value = defaultAmount
        }

        // global  action
        btn_about_app.setOnClickListener {
            val action = MainNavGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }
    }
}