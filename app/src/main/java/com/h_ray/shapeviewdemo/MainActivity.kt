package com.h_ray.shapeviewdemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pressedBgTv.setOnClickListener {
            Toast.makeText(this@MainActivity, "点击响应pressed", Toast.LENGTH_SHORT).show()
        }

        pressedColorTv.setOnClickListener {
            Toast.makeText(this@MainActivity, "点击响应pressed", Toast.LENGTH_SHORT).show()
        }

        selectedColorTv.setOnClickListener{
            val isSelected: Boolean = selectedColorTv.isSelected
            Toast.makeText(this@MainActivity, "selected = ${!isSelected}", Toast.LENGTH_SHORT).show()
            selectedColorTv.isSelected = !isSelected
        }

        selectedEnableTv.setOnClickListener {
            val isEnable = selectedEnableTv.isEnabled
            Toast.makeText(this@MainActivity, "selected = ${!isEnable}", Toast.LENGTH_SHORT).show()
            selectedEnableTv.isEnabled = !isEnable
        }

    }
}
