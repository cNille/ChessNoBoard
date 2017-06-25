package se.shapeapp.chessnoboard

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    interface spot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardSize = 8
        for (i in 1..64){
            // Init a tempView for this spot
            var temp = TextView(this)
            temp.gravity = Gravity.CENTER
            temp.id = i

            // Calc info of position
            val isTopRow = i < boardSize
            val isLeftColumn = (i-1) % boardSize == 0
            val isDark = (i + ((i-1) / 8)) % 2 == 0

            // Color the spot
            var c: String
            if(isDark){
                c = "#ffffff"
            } else {
                c = "#eeeeee"
            }
            temp.setBackgroundColor(Color.parseColor(c))


            // Set onclick listener to change colors.
            temp.setOnClickListener { v ->
                val color = if (isDark) "#66cc66" else "#44aa44"
                v.setBackgroundColor(Color.parseColor(color)) }

            // Calculate dimensions of brick
            val scale = resources.getDisplayMetrics().density
            val size = (40 * scale + 0.5f).toInt()
            val params = RelativeLayout.LayoutParams(size, size)



            // Set alignments
            if(isTopRow){
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP)
            } else {
                params.addRule(RelativeLayout.BELOW, i - boardSize)
            }
            if (isLeftColumn && !isTopRow) {
                params.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
            } else {
                params.addRule(RelativeLayout.RIGHT_OF, i - 1)
            }
            temp.layoutParams = params

            // Add spot to board
            board.addView(temp)
        }
    }








}
