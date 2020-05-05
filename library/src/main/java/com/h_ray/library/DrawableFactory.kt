package com.h_ray.library;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import com.h_ray.library.drawable.SelectorDrawable;
import com.h_ray.library.drawable.SelectorTextColorDrawable;
import com.h_ray.library.drawable.ShapeDrawable;

/**
 * @author H-ray
 * @desc：Drawable类型生产工厂
 */
object DrawableFactory {

    /**
     * 生产Shape Drawable类型的Drawable
     */
    fun getShapeDrawable(typedArray: TypedArray) : Drawable? {
        return ShapeDrawable(typedArray).createDrawable()
    }

    /**
     * 生产selector Drawable类型的Drawable
     */
    fun getSelectorDrawable(typedArray: TypedArray): Drawable? {
        return SelectorDrawable (typedArray).createDrawable()
    }

    /**
     * 生产selector Drawable类型的颜色选择器
     */
    fun getSelectorColor(typedArray: TypedArray): ColorStateList? {
        return SelectorTextColorDrawable (typedArray).createDrawable()
    }

}
