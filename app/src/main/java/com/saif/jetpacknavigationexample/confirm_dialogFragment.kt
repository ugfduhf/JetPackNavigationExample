package com.saif.jetpacknavigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*


class confirm_dialogFragment : BottomSheetDialogFragment() {

    private val args:confirm_dialogFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        return inflater.inflate(R.layout.fragment_confirm_dialog,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val receiverName = args.reseiverName
        val amount = args.amount

        tv_message.text = "Do you want to send Rs$amount to $receiverName?"

        btn_yas.setOnClickListener {
            Toast.makeText(requireContext(),"$amount has been sent to $receiverName",Toast.LENGTH_LONG).show()
            dismiss()
        }

        btn_no.setOnClickListener {
            dismiss()
        }
    }
}