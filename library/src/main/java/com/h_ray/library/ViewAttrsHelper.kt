package com.h_ray.library;

import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.h_ray.library.util.AspectRatioMeasure

/**
 * @author H-ray
 *
 * @desc：View自定义属性初始化Helper
 */
class ViewAttrsHelper {

    /**
     * 宽高比
     */
    private var mAspectRatio = 0f

    /**
     * 宽高值
     *
     * 根据宽高比计算出准确的宽高值
     */
    var spec = AspectRatioMeasure.Spec(0, 0)

    fun initAttrsDrawable(view : View, context : Context, attrs : AttributeSet) {
        var typeArray : TypedArray? = null
        try {
            if (view is FrameLayout) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HFrameLayout)
            } else if (view is LinearLayout) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HLinearLayout)
            } else if (view is RelativeLayout) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HRelativeLayout)
            } else if (view is ConstraintLayout) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HConstraintLayout)
            } else if (view is Button) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HButton)
            } else if (view is EditText) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HEditText)
            } else if (view is TextView) {
                typeArray = context.obtainStyledAttributes(attrs, R.styleable.HTextView)
            } else {
                return
            }

            if ((view is TextView) && typeArray.indexCount > 0) {
                var colorStateList = DrawableFactory.getSelectorColor(typeArray)
                if (colorStateList != null) {
                    view.setTextColor(colorStateList)
                }
            }

            mAspectRatio = if (typeArray.hasValue(R.styleable.Background_h_aspect_ratio)) {
                typeArray.getFloat(R.styleable.Background_h_aspect_ratio, 0f)
            } else {
                0f
            }

            if (typeArray.indexCount > 0) {
                //优先设置Selector效果
                var drawable = DrawableFactory.getSelectorDrawable(typeArray)
                if (drawable == null) {
                    //设置Shape效果
                    drawable = DrawableFactory.getShapeDrawable(typeArray)
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.background = drawable
                } else {
                    view.setBackgroundDrawable(drawable)
                }

            }
        } catch (e : Exception) {
            Log.e("com.h_ray.library", "请检查您使用的GView背景的xml文件")
            e.printStackTrace()
        } finally {
            typeArray?.recycle()
        }
    }

    /**
     * View onMeasure
     *
     * 宽高比计算宽高值
     */
    fun onMeasure(widthMeasureSpec : Int, heightMeasureSpec : Int,
            widthPadding :Int, heightPadding : Int, layoutParams : ViewGroup.LayoutParams) {
        spec.width = widthMeasureSpec
        spec.height = heightMeasureSpec

        if (mAspectRatio <= 0f) {
            return
        }

        AspectRatioMeasure.updateMeasureSpec(
                spec,
                mAspectRatio,
                layoutParams,
                widthPadding,
                heightPadding)
    }

}
