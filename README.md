### 效果预览
![效果图](https://github.com/xhh1993/ShapeViewDemo/blob/master/screen_shot/shot1.jpg)

### Module说明
- 消除常见的shape，selector文件
- 可使用控件类型
    <br/>1：HFrameLayout （FrameLayout类型）
    <br/>2：HLinearLayout （LinearLayout类型）
    <br/>3：HRelativeLayout （RelativeLayout类型）
    <br/>4：HConstraintLayout （ConstraintLayout类型）
    <br/>5：HTextView （TextView类型）
    <br/>6：HButton （Button类型）
    <br/>7：HEditText: （EditText类型）
    
### 自定义属性说明

##### 属性约束关系 #####
- 所有自定义控件目前支持下方表格属性设置背景
- 设置selector效果时，可设置shape属性作为默认样式
- selector效果仅支持常见三种属性（填充，边线颜色，边线宽度）,其他属性（形状，圆角，渐变）为统一属性，不随动作state改变
- 因为公共属性关系，部分控件不支持部分属性（比如TextView及其子View类型才支持文字颜色selector）

##### shape属性类型 ##### 
| 属性 | 类型 | 说明 | 
| - | - | - |
| h_aspect_ratio | float | 宽高比（宽高不能都为wrap_content） | 
| h_shape_solid | color | shape填充色 | 
| h_shape_stroke_color | color | 边线颜色 | 
| h_shape_stroke_width | dimension | 边线宽度 | 
| h_shape_corners_radius | dimension | 圆角大小（优先级高于下面四个） | 
| h_shape_corners_radius_left_top | dimension | 左上圆角大小 | 
| h_shape_corners_radius_left_bottom | dimension | 左下圆角大小 | 
| h_shape_corners_radius_right_top | dimension | 右上圆角大小 | 
| h_shape_corners_radius_right_bottom | dimension | 右下圆角大小 | 
| h_shape_type | enum | 形状类型（rectangle，oval，line，ring） | 
| h_shape_gradient_start_color | color | 渐变开始颜色 | 
| h_shape_gradient_end_color | color | 渐变结束颜色 | 
| h_shape_gradient_angle | color | 渐变角度 | 

##### selector属性类型 #####
| 属性 | 类型 | 说明 | 
| - | - | - |
| h_selector_pressed_solid | color | pressed = true填充色 | 
| h_selector_pressed_stroke_color | color | pressed = true边线色 | 
| h_selector_pressed_stroke_width | dimension | pressed = true边线宽 | 
| h_selector_selected_solid | color | selected = true填充色 | 
| h_selector_selected_stroke_color | color | selected = true边线色 | 
| h_selector_selected_stroke_width | dimension | selected = true边线宽 | 
| h_selector_enable_solid | color | enable = true填充色 | 
| h_selector_enable_stroke_color | color | enable = true边线色 | 
| h_selector_enable_stroke_width | dimension | enable = true边线宽 | 
| h_selector_focused_solid | color | focused = true填充色 | 
| h_selector_focused_stroke_color | color | focused = true边线色 | 
| h_selector_focused_stroke_width | dimension | focused = true边线宽 | 
| h_selector_default_text_color | color | 默认文字颜色 | 
| h_selector_pressed_text_color | color | pressed = true文字颜色 | 
| h_selector_selected_text_color | color | selected = true填充色 | 
| h_selector_enable_text_color | color | enable = true填充色 |

