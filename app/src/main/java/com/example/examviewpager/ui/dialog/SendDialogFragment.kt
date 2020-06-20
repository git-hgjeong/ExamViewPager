package com.example.examviewpager.ui.dialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.examviewpager.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_AMOUNT = "amount"

class SendDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_send_dialog, container, false)
        var param1 : String = "init";
        var amount : String = "";
        arguments.let {
            if (it != null) {
                param1 = it.getString(ARG_PARAM1, "none")
                amount = it.getString(ARG_AMOUNT, "$0.00")
            }
        }
        val paramTextView : TextView = view.findViewById(R.id.txtTitle)
        paramTextView.text = param1

        val paramAmount : TextView = view.findViewById(R.id.txtAmount)
        if(param1 != "ID"){
            paramAmount.text = amount
            paramAmount.visibility = View.VISIBLE
        }else{
            paramAmount.visibility = View.INVISIBLE
        }

        val btnClose : Button = view.findViewById(R.id.btnDialogClose)
        btnClose.setOnClickListener{
            dismiss()
        }
        return view
    }

}