package com.h_ray.library.drawable

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import com.h_ray.library.R

/**
 *
 * @author H-ray
 *
 * @desc : Shape类型Drawable
 *
 */
class ShapeDrawable(ta: TypedArray) : IDrawable {

    private var mTypedArray: TypedArray = ta

    
    override fun createDrawable(): Drawable? {
        var gradientDrawable = GradientDrawable()

        setBaseDrawable(gradientDrawable)

        //填充色设置 
        if (mTypedArray.hasValue(R.styleable.Background_h_shape_solid)) {
            gradientDrawable.setColor(mTypedArray.getColor(R.styleable.Background_h_shape_solid, 0))
        } 

        //边界线设置
        val strokeWidth =
            mTypedArray.getDimension(R.styleable.Background_h_shape_stroke_width, 0f)
        if (strokeWidth > 0) {
            gradientDrawable.setStroke(
                strokeWidth.toInt(),
                mTypedArray.getColor(R.styleable.Background_h_shape_stroke_color, 0)
            )
        }
        
        return gradientDrawable
    }

    /**
     * 设置默认公共属性【形状、圆角、渐变】
     */
    private fun setBaseDrawable(gradientDrawable: GradientDrawable) {
        //形状设置
        gradientDrawable.shape = mTypedArray.getInt(R.styleable.Background_h_shape_type, 0)

        //圆角设置
        val radius: Float =
            mTypedArray.getDimension(R.styleable.Background_h_shape_corners_radius, 0f)
        if (radius <= 0) {
            val leftTopRadius: Float = mTypedArray.getDimension(
                R.styleable.Background_h_shape_corners_radius_left_top, 0f
            )
            val leftBottomRadius: Float = mTypedArray.getDimension(
                R.styleable.Background_h_shape_corners_radius_left_bottom, 0f
            )
            val rightTopRadius: Float = mTypedArray.getDimension(
                R.styleable.Background_h_shape_corners_radius_right_top, 0f
            )
            val rightBottomRadius: Float = mTypedArray.getDimension(
                R.styleable.Background_h_shape_corners_radius_right_bottom, 0f
            )
            gradientDrawable.cornerRadii = floatArrayOf(
                leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius
                , rightBottomRadius, rightBottomRadius, leftBottomRadius,
                leftBottomRadius
            )
        } else {
            gradientDrawable.cornerRadii = floatArrayOf(
                radius,
                radius,
                radius,
                radius,
                radius,
                radius,
                radius,
                radius
            )
        }

        //渐变设置
        val startColor =
            mTypedArray.getColor(R.styleable.Background_h_shape_gradient_start_color, 0)
        if (startColor != 0) {
            val colors = IntArray(2)
            colors[0] = startColor
            colors[1] =
                mTypedArray.getColor(R.styleable.Background_h_shape_gradient_end_color, 0)
            gradientDrawable.colors = colors
            var gradientAngle =
                mTypedArray.getInt(R.styleable.Background_h_shape_gradient_angle, 0)
            gradientAngle %= 360
            var mOrientation =
                GradientDrawable.Orientation.LEFT_RIGHT
            when (gradientAngle) {
                0 -> mOrientation = GradientDrawable.Orientation.LEFT_RIGHT
                45 -> mOrientation = GradientDrawable.Orientation.BL_TR
                90 -> mOrientation = GradientDrawable.Orientation.BOTTOM_TOP
                135 -> mOrientation = GradientDrawable.Orientation.BR_TL
                180 -> mOrientation = GradientDrawable.Orientation.RIGHT_LEFT
                225 -> mOrientation = GradientDrawable.Orientation.TR_BL
                270 -> mOrientation = GradientDrawable.Orientation.TOP_BOTTOM
                315 -> mOrientation = GradientDrawable.Orientation.TL_BR
            }
            gradientDrawable.orientation = mOrientation
        }
    }

    /**
     * selector Pressed = true属性
     */
    fun createSelectorPressedDrawable(): Drawable? {
        val pressedTrueDrawable = GradientDrawable()
        if (mTypedArray == null) {
            return pressedTrueDrawable
        }
        setBaseDrawable(pressedTrueDrawable)

        //填充色设置
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_pressed_solid)) {
            pressedTrueDrawable.setColor(
                mTypedArray.getColor(R.styleable.Background_h_selector_pressed_solid, 0)
            )
        }

        //边界线设置
        val strokeWidth = mTypedArray.getDimension(
            R.styleable.Background_h_selector_pressed_stroke_width, 0f
        )
        if (strokeWidth > 0) {
            pressedTrueDrawable.setStroke(
                strokeWidth.toInt(),
                mTypedArray.getColor(R.styleable.Background_h_selector_pressed_stroke_color, 0)
            )
        }
        return pressedTrueDrawable
    }

    /**
     * selector selected = true属性
     */
    fun createSelectorSelectedDrawable(): Drawable? {
        val selectedTrueDrawable = GradientDrawable()
        if (mTypedArray == null) {
            return selectedTrueDrawable
        }
        setBaseDrawable(selectedTrueDrawable)

        //填充色设置
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_selected_solid)) {
            selectedTrueDrawable.setColor(
                mTypedArray.getColor(R.styleable.Background_h_selector_selected_solid, 0)
            )
        }

        //边界线设置
        val strokeWidth = mTypedArray.getDimension(
            R.styleable.Background_h_selector_selected_stroke_width, 0f
        )
        if (strokeWidth > 0) {
            selectedTrueDrawable.setStroke(
                strokeWidth.toInt(),
                mTypedArray.getColor(R.styleable.Background_h_selector_selected_stroke_color, 0)
            )
        }
        return selectedTrueDrawable
    }

    /**
     * selector enable = true属性
     */
    fun createSelectorEnableDrawable(): Drawable? {
        val selectedTrueDrawable = GradientDrawable()
        if (mTypedArray == null) {
            return selectedTrueDrawable
        }
        setBaseDrawable(selectedTrueDrawable)

        //填充色设置
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_enable_solid)) {
            selectedTrueDrawable.setColor(
                mTypedArray.getColor(R.styleable.Background_h_selector_enable_solid, 0)
            )
        }

        //边界线设置
        val strokeWidth = mTypedArray.getDimension(
            R.styleable.Background_h_selector_selected_stroke_width, 0f
        )
        if (strokeWidth > 0) {
            selectedTrueDrawable.setStroke(
                strokeWidth.toInt(),
                mTypedArray.getColor(R.styleable.Background_h_selector_enable_stroke_color, 0)
            )
        }
        return selectedTrueDrawable
    }

    /**
     * selector Focused = true属性
     */
    fun createSelectorFocusedDrawable(): Drawable? {
        val focusedTrueDrawable = GradientDrawable()
        if (mTypedArray == null) {
            return focusedTrueDrawable
        }
        setBaseDrawable(focusedTrueDrawable)

        //填充色设置
        if (mTypedArray.hasValue(R.styleable.Background_h_selector_focused_solid)) {
            focusedTrueDrawable.setColor(
                mTypedArray.getColor(R.styleable.Background_h_selector_focused_solid, 0)
            )
        }

        //边界线设置
        val strokeWidth = mTypedArray.getDimension(
            R.styleable.Background_h_selector_focused_stroke_width, 0f
        )
        if (strokeWidth > 0) {
            focusedTrueDrawable.setStroke(
                strokeWidth.toInt(),
                mTypedArray.getColor(R.styleable.Background_h_selector_focused_stroke_color, 0)
            )
        }
        return focusedTrueDrawable
    }

}