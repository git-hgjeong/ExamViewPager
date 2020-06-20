package com.example.examviewpager.ui.dialog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.viewpager.widget.ViewPager
import com.example.examviewpager.R
import com.example.examviewpager.ui.main.SectionsPagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_AMOUNT = "amount"

class PayDialogFragment : DialogFragment() {
    private var nowPageIdx : Int = 0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_pay_dialog, container, false)
        val viewPageAdapter = SectionsPagerAdapter(childFragmentManager)
        val viewPager: ViewPager = root.findViewById(R.id.view_pager)
        viewPager.adapter = viewPageAdapter
        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
            override fun onPageSelected(position: Int) {
                nowPageIdx = position
                Log.d("[onPageSelected]", nowPageIdx.toString())
            }
        })

        val btnOk : Button = root.findViewById(R.id.btnOk)
        btnOk.setOnClickListener{
            dismiss()
        }

        val btnCancel : Button = root.findViewById(R.id.btnCancel)
        btnCancel.setOnClickListener{
            dismiss()
        }

        return root
    }

}