package com.example.hoangcv2_assiagnment.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.hoangcv2_assiagnment.R

class ProductCustomView : FrameLayout {
    var resId: Int = 0

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        LayoutInflater.from(context).inflate(R.layout.product_custom_view, this)
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.MyItem)
        try {
//            resId = a.getResourceId(R.styleable.MyItem_Image_src, 0)
//            txtTitleItem.setText(a.getString(R.styleable.MyItem_Title3_item))
//            txtPriceItem.setText(a.getString(R.styleable.MyItem_Price2_item))
//            txtTitleItem.setTextColor(a.getColor(R.styleable.MyItem_Text_Color_item,0))
        } finally {
            a.recycle()
        }
        if (resId != 0) {
//            imageViewItem.setImageResource(resId)
        }
    }
}