package com.h_ray.library.drawable

import android.graphics.drawable.Drawable

/**
 *
 * @author H-ray
 *
 * @desc : 生产Drawable
 *
 */
interface IDrawable {

    /**
     * 生产 (Shape / Selector) Drawable
     */
    fun createDrawable() : Drawable?

}