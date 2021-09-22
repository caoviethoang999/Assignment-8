package com.example.hoangcv2_assiagnment

import com.example.hoangcv2_assiagnment.model.Category
import java.util.*

enum class Status {
    DETAIL,CATEGORY
}
interface OnItemClickListener{
    fun onItemClick(position: Int, status: Status)
}