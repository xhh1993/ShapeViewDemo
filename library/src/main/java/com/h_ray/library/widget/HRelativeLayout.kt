package com.h_ray.library.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.h_ray.library.ViewAttrsHelper

/**
 * @author H-ray
 * @desc： 自定义RelativeLayout
 */
class HRelativeLayout : RelativeLayout {

    private lateinit var mViewAttrsHelper: ViewAttrsHelper

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        if(attrs != null){
            mViewAttrsHelper = ViewAttrsHelper()
            mViewAttrsHelper.initAttrsDrawable(this, context, attrs)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if(mViewAttrsHelper != null){
            mViewAttrsHelper.onMeasure(
                widthMeasureSpec, heightMeasureSpec,
                paddingLeft + paddingRight,
                paddingTop + paddingBottom,
                layoutParams
            )
            super.onMeasure(mViewAttrsHelper.spec.width, mViewAttrsHelper.spec.height)
            return
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

}
