package com.example.hoangcv2_assiagnment


import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewProductMargin(val columns: Int, var margin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position: Int = parent.getChildLayoutPosition(view)
//        outRect.bottom = margin!!
        //get position as first row
//        if (position < columns!!) {
//            outRect.left = margin!!
//        }
//        get position as first columns
        if (position % columns != 0) {
            outRect.left = margin
        }
        outRect.top = margin
    }
}