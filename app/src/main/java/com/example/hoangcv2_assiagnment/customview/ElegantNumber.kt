package com.example.hoangcv2_assiagnment.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.databinding.ElegantNumberBinding


class ElegantNumber : FrameLayout, View.OnClickListener {

    private var binding: ElegantNumberBinding =
        ElegantNumberBinding.inflate(LayoutInflater.from(context), this, true)
    var count:Int =0
    constructor(context: Context?) : super(context!!) {
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        binding.root
        binding.btnMinus.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnMinus ->
            {
                if(checkNumber(binding.txtNumber.text.toString())){
                    count--
                    binding.txtNumber.text= count.toString()
                }
            }
            R.id.btnPlus ->{
                count++
                binding.txtNumber.text= count.toString()
            }
        }
    }
    fun checkNumber(numberCheck:String):Boolean{
        return numberCheck.toInt() >0
    }
    fun getNumber(): String {
        return binding.txtNumber.text.toString()
    }
}