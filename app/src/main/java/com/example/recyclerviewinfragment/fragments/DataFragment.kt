package com.example.recyclerviewinfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recyclerviewinfragment.R
import com.example.recyclerviewinfragment.databinding.FragmentDataBinding
import com.example.recyclerviewinfragment.databinding.FragmentRecyclerViewBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DataFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentDataBinding

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
        binding = FragmentDataBinding.inflate(inflater , container , false)

        name = arguments?.getString("Name")
        des = arguments?.getString("Description")
        fee = arguments?.getString("Fee")

        val cName = binding.cname
        val cDes = binding.description
        val cFee = binding.fee

        cName.text = name
        cDes.text = des
        cFee.text = fee

        return binding.root
    }
}