package com.saif.jetpacknavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_choose_receiver.*


class ChooseReceiverFragment : Fragment(R.layout.fragment_choose_receiver) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next.setOnClickListener {

            //val navOption = NavOptions.Builder()

            val receiverName = et_receiver_name.text.toString()



            val action = ChooseReceiverFragmentDirections
                .actionChooseReceiverFragmentToSendCachFragment(receiverName  )
            findNavController().navigate(action)

        }
    }
}