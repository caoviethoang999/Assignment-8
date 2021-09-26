package com.example.hoangcv2_assiagnment.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.hoangcv2_assiagnment.R
import com.example.hoangcv2_assiagnment.databinding.ButtonCustomViewBinding

class ButtonCustomView : FrameLayout {
    private var binding: ButtonCustomViewBinding =
        ButtonCustomViewBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        binding.root
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.MyButton)
        try {
            binding.textViewButton.text = a.getString(R.styleable.MyButton_Title)
            val color = a.getColor(R.styleable.MyButton_Text_Color, 0)
            binding.textViewButton.setTextColor(color)

        } finally {
            a.recycle()
        }
    }
}