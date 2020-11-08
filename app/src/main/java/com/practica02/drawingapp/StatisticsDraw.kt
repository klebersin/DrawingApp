package com.practica02.drawingapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class StatisticsDraw @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var points = arrayOf(arrayOf(1, 3), arrayOf(2, 20), arrayOf(3, 30),
            arrayOf(4, 2), arrayOf(5, 0), arrayOf(6, 2), arrayOf(7, 3))

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint: Paint = Paint()
        paint.setTextSize(20f)
        for (num in 0..10){
            canvas?.drawLine(200f,50*num+500f, 1000f, 50*num+500f , paint)

        }
        paint.style = Paint.Style.STROKE

        canvas?.drawRect(25f,300f,1050f,1150f,paint);
        paint.reset()
        paint.setStrokeWidth(5f)
        paint.setTextSize(25f)
        for(num in 1..7){
            canvas?.drawText("Día "+num, 100f*num + 170 , 1050f,paint)
        }
        paint.setTextSize(50f)
        canvas?.drawText("Progreso ", 500f , 400f,paint)
        paint.setTextSize(30f)
        canvas?.drawText("Días ", 100*4+200f , 1100f,paint)
        canvas?.save();
        canvas?.rotate(270f, 100f, 750f);
        canvas?.drawText("Kilómetros ", 100f , 750f,paint)
        canvas?.restore();


        var inter = getIntervalo(points).toFloat()
        canvas?.drawText(inter.toString(), 700f , 1550f,paint)
        var pointX = points[0][0]
        var pointY = points[0][1]

        for (j in points){
            paint.setColor(Color.MAGENTA)

            canvas?.drawLine(pointX*100+200f,1000-pointY*inter, j[0]*100+200f, 1000-j[1]*inter , paint)
            paint.setColor(Color.GRAY)
            canvas?.drawText(j[1].toString(), j[0]*100+190f , 1000-j[1]*inter-10, paint)
            pointX = j[0]
            pointY = j[1]
        }

    }

    private fun getIntervalo(points: Array<Array<Int>>): Double {
        var max: Int = 0
        for(i in points){
            if(max < i[1]) {
                max = i[1]
            }
        }
        return 500/max.toDouble()
    }
}

