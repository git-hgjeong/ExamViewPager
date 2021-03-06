package com.example.examviewpager.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.examviewpager.R
import com.example.examviewpager.ui.dialog.PayDialogFragment
import com.example.examviewpager.ui.dialog.SendDialogFragment
import com.example.examviewpager.ui.main.SectionsPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var nowPageIdx : Int = 0;
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
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

        val btnPay : Button = root.findViewById(R.id.btnPay)
        btnPay.setOnClickListener {
            val dialog = PayDialogFragment()
            dialog.setStyle( DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );
            dialog.show(parentFragmentManager, "dialog")
        }

        return root
    }

    fun getChkFragment() : String {
        Log.d("[HomePlagment]==>","PAY")
        return "PAY"
    }

    fun getCardinfo() : String{
        return nowPageIdx.toString()
    }

}