package com.example.hoangcv2_assiagnment

enum class Status {
    DETAIL, CATEGORY
}

interface OnItemClickListener {
    fun onItemClick(position: Int, status: Status)
}