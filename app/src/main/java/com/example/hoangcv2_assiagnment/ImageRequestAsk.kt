package com.example.hoangcv2_assiagnment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.net.URL

class ImageRequestAsk : AsyncTask<String, Void, Bitmap?>() {
    override fun doInBackground(vararg params: String): Bitmap? {
        return try {
            val inputStream = URL(params[0]).openStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            null
        }
    }

    override fun onPostExecute(bitmap: Bitmap?) {
        super.onPostExecute(bitmap)
    }
}