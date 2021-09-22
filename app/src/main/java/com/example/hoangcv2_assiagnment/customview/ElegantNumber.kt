package com.example.hoangcv2_assiagnment.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.hoangcv2_assiagnment.R
import kotlinx.android.synthetic.main.elegant_number.view.*

class ElegantNumber : FrameLayout, View.OnClickListener {
    var count:Int =0
    constructor(context: Context?) : super(context!!) {
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        LayoutInflater.from(context).inflate(R.layout.elegant_number, this)
        btnMinus.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnMinus ->
            {
                if(checkNumber(txtNumber.text.toString())){
                    count--
                    txtNumber.text= count.toString()
                }
            }
            R.id.btnPlus ->{
                count++
                txtNumber.text= count.toString()
            }
        }
    }
    fun checkNumber(numberCheck:String):Boolean{
        return numberCheck.toInt() >0
    }
    fun getNumber(): String {
        return txtNumber.text.toString()
    }
}