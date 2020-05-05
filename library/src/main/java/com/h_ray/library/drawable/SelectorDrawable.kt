package com.h_ray.library.drawable
 
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import com.h_ray.library.R

/**
 *
 * @author H-ray
 *
 * @desc : Selector类型Drawable
 *
 */
class SelectorDrawable(ty : TypedArray) : IDrawable{
    
    private var mTypedArray : TypedArray = ty

    override fun createDrawable(): Drawable? {
        var stateListDrawable: StateListDrawable? = null
        val shapeDrawable = ShapeDrawable(mTypedArray)
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_pressed_solid)
            || mTypedArray.hasValue(R.styleable.Background_h_selector_pressed_stroke_width)
        ) {
            if (stateListDrawable == null) {
                stateListDrawable = StateListDrawable()
            }

            //默认效果
            val defaultDrawable =
                shapeDrawable.createDrawable() as GradientDrawable
            stateListDrawable.addState(intArrayOf(-android.R.attr.state_pressed), defaultDrawable)

            //（Pressed）按压效果
            val pressedTrueDrawable =
                shapeDrawable.createSelectorPressedDrawable() as GradientDrawable
            stateListDrawable.addState(
                intArrayOf(android.R.attr.state_pressed),
                pressedTrueDrawable
            )
        }

        if (mTypedArray.hasValue(R.styleable.Background_h_selector_selected_solid)
            || mTypedArray.hasValue(R.styleable.Background_h_selector_selected_stroke_width)
        ) {
            if (stateListDrawable == null) {
                stateListDrawable = StateListDrawable()
            }

            //默认效果
            val defaultDrawable =
                shapeDrawable.createDrawable() as GradientDrawable
            stateListDrawable.addState(intArrayOf(-android.R.attr.state_selected), defaultDrawable)

            //（Selected）选择效果
            val pressedTrueDrawable =
                shapeDrawable.createSelectorSelectedDrawable() as GradientDrawable?
            stateListDrawable.addState(
                intArrayOf(android.R.attr.state_selected),
                pressedTrueDrawable
            )
        }

        if (mTypedArray.hasValue(R.styleable.Background_h_selector_enable_solid)
            || mTypedArray.hasValue(R.styleable.Background_h_selector_enable_stroke_width)
        ) {
            if (stateListDrawable == null) {
                stateListDrawable = StateListDrawable()
            }

            //默认效果
            val defaultDrawable =
                shapeDrawable.createDrawable() as GradientDrawable
            stateListDrawable.addState(intArrayOf(-android.R.attr.state_enabled), defaultDrawable)

            //（Enable）效果
            val enableTrueDrawable =
                shapeDrawable.createSelectorEnableDrawable() as GradientDrawable?
            stateListDrawable.addState(
                intArrayOf(android.R.attr.state_enabled),
                enableTrueDrawable
            )
        }

        if (mTypedArray.hasValue(R.styleable.Background_h_selector_focused_solid)
            || mTypedArray.hasValue(R.styleable.Background_h_selector_focused_stroke_width)
        ) {
            if (stateListDrawable == null) {
                stateListDrawable = StateListDrawable()
            }

            //默认效果
            val defaultDrawable =
                shapeDrawable.createDrawable() as GradientDrawable
            stateListDrawable.addState(intArrayOf(-android.R.attr.state_focused), defaultDrawable)

            //（Focused）效果
            val focusedTrueDrawable =
                shapeDrawable.createSelectorFocusedDrawable() as GradientDrawable?
            stateListDrawable.addState(
                intArrayOf(android.R.attr.state_focused),
                focusedTrueDrawable
            )
        }

        return stateListDrawable
    }
}