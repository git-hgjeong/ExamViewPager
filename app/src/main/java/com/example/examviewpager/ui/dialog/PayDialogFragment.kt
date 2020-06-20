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
private const val ARG_PARAM2 = "param2"

class PayDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pay_dialog, container, false)
        var param1 : String = "init";
        arguments.let {
            if (it != null) {
                param1 = it.getString(ARG_PARAM1, "none")
            }
        }
        val paramTextView : TextView = view.findViewById(R.id.textView2)
        paramTextView.text = param1

        val btnClose : Button = view.findViewById(R.id.btnDialogClose)
        btnClose.setOnClickListener{
            dismiss()
        }
        return view
    }

}