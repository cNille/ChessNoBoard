package se.shapeapp.chessnoboard

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.view.Gravity
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var game = Game()
        game.startBoard()
        game.printBoard()

        val boardSize = 8
        for (i in 1..64){
            // Init a tempView for this spot
            var temp = TextView(this)
            temp.id = i

            temp.text = game.getText(i-1)
            temp.gravity = Gravity.CENTER

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

                val color = game.selectPiece(v.id, isDark)
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
