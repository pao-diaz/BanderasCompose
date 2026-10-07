package com.example.banderascompose.ui.theme

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.toColorInt

class PixelArtView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paintBlack = Paint().apply { color = "#1B1B1B".toColorInt(); style = Paint.Style.FILL }
    private val paintPink = Paint().apply { color = "#F06292".toColorInt(); style = Paint.Style.FILL }
    private val paintYellow = Paint().apply { color = "#FFD54F".toColorInt(); style = Paint.Style.FILL }
    private val paintWhite = Paint().apply { color = Color.WHITE; style = Paint.Style.FILL }

    private val paintGrid = Paint().apply {
        color = "#CCCCCC".toColorInt()
        style = Paint.Style.STROKE
        strokeWidth = 1f
    }

    private val gridWidth = 32
    private val gridHeight = 35

    private val pixelMap = arrayOf(
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,1,2,2,2,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,2,2,2,1,1,2,2,2,2,2,2,1,0,0,0,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,1,2,2,2,2,2,2,1,0,0,0,0,0,0,0,0,1,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,2,1,2,2,2,2,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,2,2,1,1,1,1,0,0,4,4,4,4,4,4,4,0,1,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,2,2,2,2,2,2,1,0,4,4,4,4,4,4,4,0,0,1,1,0,0),
        intArrayOf(0,0,0,0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,1,4,4,4,4,4,4,4,1,1,1,1,0,0),
        intArrayOf(0,0,0,0,0,0,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,4,4,4,4,1,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,0,1,1,0,1,1,2,2,2,2,2,2,1,4,4,4,4,4,4,4,4,1,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,4,4,4,4,1,1,4,4,4,1,1,1,1,1,0,0),
        intArrayOf(0,0,0,0,1,1,0,0,0,0,0,0,4,4,4,4,4,4,4,1,1,1,1,4,4,1,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,1,0,0,1,1,0,0,0,4,4,4,4,4,4,4,1,1,1,1,4,4,0,1,1,1,0,0,0),
        intArrayOf(0,0,0,0,1,1,1,1,1,0,0,0,4,4,4,3,3,4,4,4,1,1,4,4,4,0,0,1,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,0,0,0,0,0,0,4,4,4,3,3,4,4,4,4,4,4,4,4,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,1,1,1,1,1,4,4,4,4,4,4,4,4,4,4,4,4,1,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,1,1,2,2,2,4,4,2,2,2,1,1,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,4,4,4,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,4,4,4,4,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,4,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,4,4,4,4,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,4,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,1,4,4,4,4,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,4,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,1,4,4,4,1,2,2,2,2,2,2,2,2,2,2,1,4,4,4,1,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,2,2,2,2,1,1,1,1,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,2,2,2,2,2,2,2,2,2,2,1,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val pixelSizeX = width.toFloat() / gridWidth
        val pixelSizeY = height.toFloat() / gridHeight
        val pixelSize = minOf(pixelSizeX, pixelSizeY)

        val offsetX = (width.toFloat() - (gridWidth * pixelSize)) / 2
        val offsetY = (height.toFloat() - (gridHeight * pixelSize)) / 2

        for (row in 0 until gridHeight) {
            for (col in 0 until gridWidth) {
                val colorValue = pixelMap[row][col]
                val paintToUse = when (colorValue) {
                    1 -> paintBlack
                    2 -> paintPink
                    3 -> paintYellow
                    4 -> paintWhite
                    else -> null
                }

                if (paintToUse != null) {
                    val left = offsetX + (col * pixelSize)
                    val top = offsetY + (row * pixelSize)
                    val right = left + pixelSize
                    val bottom = top + pixelSize
                    canvas.drawRect(left, top, right, bottom, paintToUse)
                }
            }
        }

        for (col in 0..gridWidth) {
            val x = offsetX + (col * pixelSize)
            canvas.drawLine(x, offsetY, x, offsetY + (gridHeight * pixelSize), paintGrid)
        }

        for (row in 0..gridHeight) {
            val y = offsetY + (row * pixelSize)
            canvas.drawLine(offsetX, y, offsetX + (gridWidth * pixelSize), y, paintGrid)
        }
    }
}