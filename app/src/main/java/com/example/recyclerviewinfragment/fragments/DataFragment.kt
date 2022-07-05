package com.example.recyclerviewinfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recyclerviewinfragment.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DataFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var name: String? = ""
    private var des: String? = ""
    private var fee: String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        var view =  inflater.inflate(R.layout.fragment_data, container, false)

        name = arguments?.getString("Name")
        des = arguments?.getString("Description")
        fee = arguments?.getString("Fee")

        val cName = view.findViewById<TextView>(R.id.cname)
        val cDes = view.findViewById<TextView>(R.id.description)
        val cFee = view.findViewById<TextView>(R.id.fee)

        cName.text = name
        cDes.text = des
        cFee.text = fee

        return view
    }
}