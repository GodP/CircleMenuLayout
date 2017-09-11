package com.example.administrator.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by Administrator on 2017/8/22 0022.
 */


class NineView : View {

    // 二维数组初始化，int[3][3]
    private var mPoints: Array<Array<Point?>> = Array(3) { Array<Point?>(3, { null }) }
    // 是否初始化
    private var mDotRadius = 0
    private lateinit var mLinePaint: Paint
    private lateinit var mPressedPaint: Paint
    private lateinit var mErrorPaint: Paint
    private lateinit var mNormalPaint: Paint
    private lateinit var mArrowPaint: Paint
    // 颜色
    private val mOuterPressedColor = 0xff8cbad8.toInt()
    private val mInnerPressedColor = 0xff0596f6.toInt()
    private val mOuterNormalColor = 0xffd9d9d9.toInt()
    private val mInnerNormalColor = 0xff929292.toInt()
    private val mOuterErrorColor = 0xff901032.toInt()
    private val mInnerErrorColor = 0xffea0945.toInt()


    private var mIsInit = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)


    override fun onDraw(canvas: Canvas) {
        if (!mIsInit) {
            initDot()
            initPaint()
            mIsInit = true
        }

        drawShow(canvas)
    }

    private fun drawShow(canvas: Canvas) {
        for(i in 0..2){
            for (point in mPoints[i]){
                //先绘制外圆
                canvas.drawCircle(point!!.centerX.toFloat(),point.centerY.toFloat(),mDotRadius.toFloat(),mNormalPaint)

                //后绘制内圆

                mNormalPaint.color = mInnerNormalColor
                canvas.drawCircle(point!!.centerX.toFloat(),point.centerY.toFloat(),mDotRadius/6.toFloat(),mNormalPaint)
            }
        }
    }

    /**
     * 初始化画笔
     * 3个点状态的画笔，线的画笔，箭头的画笔
     */
    private fun initPaint() {

        // new paint 对象， 设置paint 颜色
        //线的画笔
        mLinePaint = Paint()
        mLinePaint.color = mInnerPressedColor
        mLinePaint.style = Paint.Style.STROKE
        mLinePaint.isAntiAlias = true
        mLinePaint.strokeWidth = (mDotRadius / 9).toFloat()
        // 按下的画笔
        mPressedPaint = Paint()
        mPressedPaint.style = Paint.Style.STROKE
        mPressedPaint.isAntiAlias = true
        mPressedPaint.strokeWidth = (mDotRadius / 6).toFloat()
        // 错误的画笔
        mErrorPaint = Paint()
        mErrorPaint.style = Paint.Style.STROKE
        mErrorPaint.isAntiAlias = true
        mErrorPaint.strokeWidth = (mDotRadius / 6).toFloat()
        // 默认的画笔
        mNormalPaint = Paint()
        mNormalPaint.style = Paint.Style.STROKE
        mNormalPaint.isAntiAlias = true
        mNormalPaint.strokeWidth = (mDotRadius / 9).toFloat()
        // 箭头的画笔
        mArrowPaint = Paint()
        mArrowPaint.color = mInnerPressedColor
        mArrowPaint.style = Paint.Style.FILL
        mArrowPaint.isAntiAlias = true

    }

    /**
     * 初始化点
     */
    private fun initDot() {

        //九宫格  存到集合  point[3][3]
        var width =this.width
        var height = this.height

        var squareWidth =width/3
        var offsetY = (height -width)/2

        mDotRadius = width/12
        mPoints[0][0] = Point(squareWidth/2,offsetY+squareWidth/2,0)
        mPoints[0][1] = Point(squareWidth*3/2,offsetY+squareWidth/2,1)
        mPoints[0][2] = Point(squareWidth*5/2,offsetY+squareWidth/2,2)
        mPoints[1][0] = Point(squareWidth/2,offsetY+squareWidth*3/2,3)
        mPoints[1][1] = Point(squareWidth*3/2,offsetY+squareWidth*3/2,4)
        mPoints[1][2] = Point(squareWidth*5/2,offsetY+squareWidth*3/2,5)
        mPoints[2][0] = Point(squareWidth/2,offsetY+squareWidth*5/2,6)
        mPoints[2][1] = Point(squareWidth*3/2,offsetY+squareWidth*5/2,7)
        mPoints[2][2] = Point(squareWidth*5/2,offsetY+squareWidth*5/2,8)
    }

    private var mMovingX = 0f
    private var mMovingY = 0f
    override fun onTouchEvent(event: MotionEvent): Boolean {
        mMovingX = event.x
        mMovingY = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN ->{
                //判断手指是不是按在一个宫格上面
                //如何判断一个点在圆里面     点到圆心的距离<半径

            }
            MotionEvent.ACTION_MOVE->{

            }
            MotionEvent.ACTION_UP->{

            }
        }
        return true
    }

    /**
     * 获取按下的点
     */
    private val point:Point?
    get() {
        for (i in mPoints.indices){
            for (j in 0 ..mPoints[i].size-1){
                val point = mPoints[i][j]

            }
        }
        return null
    }

    class Point(var centerX:Int,var centerY:Int,var index:Int){
        private final var STATUS_NORMAL =1
        private final var STATUS_PRESSED =2
        private final var STATUS_ERROR=3
        //当前点的状态  有3种状态
        private var status = STATUS_NORMAL
    }
}