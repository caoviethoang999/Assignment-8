package com.example.hoangcv2_assiagnment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hoangcv2_assiagnment.R
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment(), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnHome.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnHome->{
                val recylerFragment = HomeFragment()
                activity?.supportFragmentManager?.beginTransaction()
                    ?.addToBackStack(null)?.replace(R.id.fragment_container, recylerFragment)?.commit()
            }
        }
    }
}