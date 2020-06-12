package com.example.examviewpager.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.examviewpager.R
import com.example.examviewpager.ui.main.SectionsPagerAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val viewPageAdapter = SectionsPagerAdapter(childFragmentManager)
        val viewPager: ViewPager = root.findViewById(R.id.view_pager)
        viewPager.adapter = viewPageAdapter
        return root
    }
}