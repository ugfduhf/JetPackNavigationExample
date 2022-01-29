package com.saif.jetpacknavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        btn_viewBalance.setOnClickListener {
            //val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            navController.navigate(R.id.view_balance_Fragment,null,navOptions)
        }

        btn_viewTrans.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionFragment()
            navController.navigate(action)
        }
        btn_send.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }


    }
}