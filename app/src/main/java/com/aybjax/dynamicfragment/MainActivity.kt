package com.aybjax.dynamicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentContainerView

const val STAR_SIGN_ID = "STAR_SIGN_ID"

interface StarSignListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), StarSignListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("aybjax", "before setting content")
        setContentView(R.layout.activity_main)
        Log.d("aybjax", "after setting content")

        if(savedInstanceState == null) {

            findViewById<FragmentContainerView>(R.id.fragment_container)?.let { frameLayout ->

                val listFragment = ListFragment()

                supportFragmentManager.beginTransaction()
                    .add(frameLayout.id, listFragment).commit()
            }
        }
    }

    override fun onSelected(starSignId: Int) {
        findViewById<FragmentContainerView>(R.id.fragment_container)?.let {frameLayout ->
            val detailFragment = DetailFragment.newInstance(starSignId)
            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}