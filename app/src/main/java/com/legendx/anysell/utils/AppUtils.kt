package com.legendx.anysell.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory

object AppUtils {
    fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

}