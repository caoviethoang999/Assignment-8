package com.example.hoangcv2_assiagnment.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.hoangcv2_assiagnment.R
import kotlinx.android.synthetic.main.button_custom_view.view.*

class ButtonCustomView : FrameLayout {

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        LayoutInflater.from(context).inflate(R.layout.button_custom_view, this)
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.MyButton)
        try {
            textViewButton.text = a.getString(R.styleable.MyButton_Title)
            val color = a.getColor(R.styleable.MyButton_Text_Color, 0)
            textViewButton.setTextColor(color)

        } finally {
            a.recycle()
        }
    }
}