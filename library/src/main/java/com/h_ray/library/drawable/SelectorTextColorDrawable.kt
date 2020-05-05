package com.h_ray.library.drawable

import android.content.res.ColorStateList
import android.content.res.TypedArray
import com.h_ray.library.R

/**
 *
 * @author H-ray
 *
 * @desc : Text Selector类型Drawable
 *
 */
class SelectorTextColorDrawable(ta : TypedArray) : IColorDrawable {

    private var mTypedArray : TypedArray = ta
    private var currPosition = 0
    private var states = arrayOf<IntArray?>()
    private var colors = intArrayOf()
    
    override fun createDrawable(): ColorStateList? {
        val selectorCount: Int = getSelectorCount()
        if (selectorCount <= 0) {
            return null
        }
        states = arrayOfNulls<IntArray?>(selectorCount)
        colors = IntArray(selectorCount)

        if (mTypedArray.hasValue(R.styleable.HTextView_h_selector_pressed_text_color)) {
            //按压(Pressed)颜色
            states[currPosition] = intArrayOf(android.R.attr.state_pressed)
            colors[currPosition] = mTypedArray.getColor(
                R.styleable.Background_h_selector_pressed_text_color, 0
            )
            currPosition++
            setDefaultColor(-android.R.attr.state_pressed)
        }

        if (mTypedArray.hasValue(R.styleable.Background_h_selector_selected_text_color)) {
            //选择(Selected)颜色
            states[currPosition] = intArrayOf(android.R.attr.state_selected)
            colors[currPosition] = mTypedArray.getColor(
                R.styleable.Background_h_selector_selected_text_color, 0
            )
            currPosition++
            setDefaultColor(-android.R.attr.state_selected)
        }

        if (mTypedArray.hasValue(R.styleable.Background_h_selector_enable_text_color)) {
            //选择(Enable)颜色
            states[currPosition] = intArrayOf(android.R.attr.state_enabled)
            colors[currPosition] = mTypedArray.getColor(
                R.styleable.Background_h_selector_enable_text_color, 0
            )
            currPosition++
            setDefaultColor(-android.R.attr.state_enabled)
        }

        return ColorStateList(states, colors)
    }

    /**
     * 获取文字selector条数
     */
    private fun getSelectorCount(): Int {
        var count = 0
        if (mTypedArray == null || mTypedArray.indexCount <= 0) {
            return count
        }
        if (mTypedArray.hasValue(R.styleable.HTextView_h_selector_pressed_text_color)) {
            count++
        }
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_selected_text_color)) {
            count++
        }
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_enable_text_color)) {
            count++
        }
        return count * 2
    }

    /**
     * 设置默认颜色selector
     */
    private fun setDefaultColor(stateId: Int) {
        if (currPosition > 0) {
            //设置默认颜色
            colors[currPosition] = mTypedArray.getColor(
                R.styleable.Background_h_selector_default_text_color, 0
            )
            states[currPosition] = intArrayOf(stateId)
            currPosition++
        }
    }
    
}