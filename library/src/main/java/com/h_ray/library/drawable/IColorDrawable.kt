package com.h_ray.library.drawable

import android.content.res.ColorStateList

/**
 *
 * @author H-ray
 *
 * @desc : 文本颜色Selector
 *
 */
interface IColorDrawable {

    /**
     * 生产文本颜色Selector类型
     */
    fun createDrawable() : ColorStateList?

}