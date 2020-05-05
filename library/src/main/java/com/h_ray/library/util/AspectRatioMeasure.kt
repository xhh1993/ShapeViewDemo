package com.h_ray.library.util

import android.view.View
import android.view.ViewGroup

/**
 * @author H-ray
 *
 * @desc：根据aspectRatio（宽/高），计算View宽高
 */
object AspectRatioMeasure {

    class Spec(w : Int, h :Int){
        var width : Int = 0
        var height : Int = 0
        init {
            width = w
            height = h
        }
    }

    /**
     * 根据宽高比计算出自适应的宽高值
     */
    fun updateMeasureSpec(spec : Spec, aspectRatio : Float, layoutParams : ViewGroup.LayoutParams, widthPadding : Int, heightPadding : Int){
        if(aspectRatio <= 0 || layoutParams == null){
            return
        }

        if(shouldAdjust(layoutParams.height)){
            val widthSpecSize = View.MeasureSpec.getSize(spec.width)
            val desiredHeight = ((widthSpecSize - widthPadding) / aspectRatio + heightPadding).toInt()
            val resolvedHeight = View.resolveSize(desiredHeight, spec.height)
            spec.height = View.MeasureSpec.makeMeasureSpec(
                resolvedHeight,
                View.MeasureSpec.EXACTLY
            )
        }else if(shouldAdjust(layoutParams.width)){
            val heightSpecSize = View.MeasureSpec.getSize(spec.height)
            val desiredWidth = ((heightSpecSize - heightPadding) * aspectRatio + widthPadding).toInt()
            val resolvedWidth = View.resolveSize(desiredWidth, spec.width)
            spec.width = View.MeasureSpec.makeMeasureSpec(
                resolvedWidth,
                View.MeasureSpec.EXACTLY
            )
        }
    }

    /**
     * 判断宽/高自适应
     */
    private fun shouldAdjust(layoutDimension: Int): Boolean {
        return layoutDimension == 0 || layoutDimension == ViewGroup.LayoutParams.WRAP_CONTENT
    }

}