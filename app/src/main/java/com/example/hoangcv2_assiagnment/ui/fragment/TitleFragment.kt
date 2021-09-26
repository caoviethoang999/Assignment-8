package com.example.hoangcv2_assiagnment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.databinding.FragmentTitleBinding
import dagger.android.support.DaggerFragment

class TitleFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var binding:FragmentTitleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.setOnClickListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnHome->{
                val recyclerFragment = HomeFragment()
                activity?.supportFragmentManager?.beginTransaction()
                    ?.addToBackStack(null)?.replace(R.id.fragment_container, recyclerFragment)?.commit()
            }
        }
    }
}