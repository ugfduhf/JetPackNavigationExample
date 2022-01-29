package com.saif.jetpacknavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_send_cach.*


class SendCachFragment : Fragment(R.layout.fragment_send_cach) {

    private val args :SendCachFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setting default amount
        et_amount.setText(sampleData.defaultAmount.value.toString())
        sampleData.defaultAmount.observe(viewLifecycleOwner){
            et_amount.setText(it.toString())
        }

        val receiverName = args.receiverName
        //val  amount = args.amount
       // et_amount.setText(amount.toString())
        tv_receiver.text = "send cash to: $receiverName"

        btn_sendCash.setOnClickListener {

            if (et_amount.text.toString().isEmpty()){
                Toast.makeText(requireContext(),"Enter some amount for $receiverName"
                    , Toast.LENGTH_LONG).show()
                return@setOnClickListener
                }

            val amount = et_amount.text.toString().toLong()
            val action = SendCachFragmentDirections
                .actionSendCachFragmentToConfirmDialogFragment(receiverName,amount)
            findNavController().navigate(action)
        }
        btn_done.setOnClickListener {
            val action = SendCachFragmentDirections.actionSendCachFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        btn_cancelCash.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,false)
        }
    }
}