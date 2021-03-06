package com.example.recyclerviewinfragment

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.recyclerviewinfragment.databinding.ActivityMainBinding
import com.example.recyclerviewinfragment.fragments.DataFragment
import com.example.recyclerviewinfragment.fragments.RecyclerViewFragment

class MainActivity : AppCompatActivity() , Communicator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        supportFragmentManager.beginTransaction().replace(binding.frameLayout.id, RecyclerViewFragment()).commit()
    }

    override fun passDataCom(courseName: String, description: String, fee: Long) {
        val bundle = Bundle()
        bundle.putString("Name", courseName)
        bundle.putString("Description", description)
        bundle.putString("Fee", fee.toString())

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = DataFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.frameLayout, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}