package com.example.examviewpager.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.examviewpager.R
import com.example.examviewpager.ui.dialog.PayDialogFragment
import java.math.BigDecimal
import java.text.DecimalFormat

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        val textView: TextView = root.findViewById(R.id.textView)
        val btn_c: Button = root.findViewById(R.id.btn_c)
        val btn_00: Button = root.findViewById(R.id.btn_00)
        val btn_1: Button = root.findViewById(R.id.btn_1)
        val btn_2: Button = root.findViewById(R.id.btn_2)
        val btn_3: Button = root.findViewById(R.id.btn_3)
        val btn_4: Button = root.findViewById(R.id.btn_4)
        val btn_5: Button = root.findViewById(R.id.btn_5)
        val btn_6: Button = root.findViewById(R.id.btn_6)
        val btn_7: Button = root.findViewById(R.id.btn_7)
        val btn_8: Button = root.findViewById(R.id.btn_8)
        val btn_9: Button = root.findViewById(R.id.btn_9)
        val btn_0: Button = root.findViewById(R.id.btn_0)

        btn_c.setOnClickListener {
            textView.text = "$0.00"
        }
        btn_1.setOnClickListener {
            textView.text = addTextViewValue(textView, "1")
        }
        btn_2.setOnClickListener {
            textView.text = addTextViewValue(textView, "2")
        }
        btn_3.setOnClickListener {
            textView.text = addTextViewValue(textView, "3")
        }
        btn_4.setOnClickListener {
            textView.text = addTextViewValue(textView, "4")
        }
        btn_5.setOnClickListener {
            textView.text = addTextViewValue(textView, "5")
        }
        btn_6.setOnClickListener {
            textView.text = addTextViewValue(textView, "6")
        }
        btn_7.setOnClickListener {
            textView.text = addTextViewValue(textView, "7")
        }
        btn_8.setOnClickListener {
            textView.text = addTextViewValue(textView, "8")
        }
        btn_9.setOnClickListener {
            textView.text = addTextViewValue(textView, "9")
        }
        btn_0.setOnClickListener {
            textView.text = addTextViewValue(textView, "0")
        }
        btn_00.setOnClickListener {
            textView.text = addTextViewValue(textView, "00")
        }
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    fun getTextViewToStr(textView: TextView): String {
        val org = textView.text
        val orgStr = org.toString()
        return orgStr
    }

    fun addTextViewValue(textView: TextView, addStr:String):String{
        val str: String = getTextViewToStr(textView)
        val len : Int = str.length
        if(len >= 15){
            return str;
        }
        val tmpStr = (str.substring(1) + addStr).replace(".", "", false)
        val newStr : String = tmpStr.replace(",", "", false)
        //return "$" + newStr
        val calDec : BigDecimal = BigDecimal("0.01")
        val dec = (newStr.toBigDecimal() * calDec).setScale(2);
//        return dec.toPlainString()
        val res : String = "$" + makeCommaNumber(dec)
        return res;
    }

    fun makeCommaNumber(input:BigDecimal): String{
        val formatter = DecimalFormat("###,##0.00")
        return formatter.format(input)
    }
}