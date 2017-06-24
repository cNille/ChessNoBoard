package se.shapeapp.chessnoboard

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewGroup
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boardSize = 8
        for (i in 1..64){
            var temp = TextView(this)
            temp.id = i

            if((i + ((i-1) / 8)) % 2 == 0){
                temp.setBackgroundColor(Color.parseColor("#ffffff"))
            } else {
                temp.setBackgroundColor(Color.parseColor("#eeeeee"))
            }

            //temp.text = "${i}"

            val isTopRow = i < boardSize
            val isLeftColumn = (i-1) % boardSize == 0

            // Calculate dimensions of brick
            val scale = resources.getDisplayMetrics().density
            val size = (40 * scale + 0.5f).toInt()
            var height = size
            var width = size
            val params = RelativeLayout.LayoutParams(width, height)

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
            temp.gravity = Gravity.CENTER
            board.addView(temp)
        }
    }







}
