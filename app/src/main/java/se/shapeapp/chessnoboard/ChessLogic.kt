package se.shapeapp.chessnoboard

import java.io.StringBufferInputStream

/**
 * Created by nille on 25/06/17.
 */


val greenDark = "#44aa44"
val greenLight = "#66cc66"
val blueDark = "#4444aa"
val blueLight = "#6666cc"
val grayDark = "#eeeeee"
val grayLight = "#ffffff"

class Game() {

    open var board: MutableList<MutableList<Piece>> = MutableList(8, { j ->
        MutableList(8, { i ->
            Piece(Pair(i, j), "EMPTY")
        })
    })

    fun getText(i: Int):String{
        return board[i/8][i%8].getString()
    }


    var from: Int = -1
    var to: Int = -1
    fun  selectPiece(id: Int, isDark: Boolean): String {
        if(from == id){
            from = -1
            to = -1
            return if(isDark) grayDark else grayLight
        } else if (from < 0){
            from = id
            return greenLight
        } else if(to < 0){
            to = id
            return greenDark
        } else {
            from = id
            to = -1
            return greenLight
        }
    }


    fun startBoard(){
        board[0][0] = Tower(Pair(0,0), "WHITE")
        board[0][1] = Knight(Pair(0,1), "WHITE")
        board[0][2] = Runner(Pair(0,2), "WHITE")
        board[0][3] = Queen(Pair(0,3), "WHITE")
        board[0][4] = King(Pair(0,4), "WHITE")
        board[0][5] = Runner(Pair(0,5), "WHITE")
        board[0][6] = Knight(Pair(0,6), "WHITE")
        board[0][7] = Tower(Pair(0,7), "WHITE")
        board[1][0] = Peasent(Pair(1,0), "WHITE")
        board[1][1] = Peasent(Pair(1,1), "WHITE")
        board[1][2] = Peasent(Pair(1,2), "WHITE")
        board[1][3] = Peasent(Pair(1,3), "WHITE")
        board[1][4] = Peasent(Pair(1,4), "WHITE")
        board[1][5] = Peasent(Pair(1,5), "WHITE")
        board[1][6] = Peasent(Pair(1,6), "WHITE")
        board[1][7] = Peasent(Pair(1,7), "WHITE")


        board[7][0] = Tower(Pair(7,0), "BLACK")
        board[7][1] = Knight(Pair(7,1), "BLACK")
        board[7][2] = Runner(Pair(7,2), "BLACK")
        board[7][3] = Queen(Pair(7,3), "BLACK")
        board[7][4] = King(Pair(7,4), "BLACK")
        board[7][5] = Runner(Pair(7,5), "BLACK")
        board[7][6] = Knight(Pair(7,6), "BLACK")
        board[7][7] = Tower(Pair(7,7), "BLACK")
        board[6][0] = Peasent(Pair(6,0), "BLACK")
        board[6][1] = Peasent(Pair(6,1), "BLACK")
        board[6][2] = Peasent(Pair(6,2), "BLACK")
        board[6][3] = Peasent(Pair(6,3), "BLACK")
        board[6][4] = Peasent(Pair(6,4), "BLACK")
        board[6][5] = Peasent(Pair(6,5), "BLACK")
        board[6][6] = Peasent(Pair(6,6), "BLACK")
        board[6][7] = Peasent(Pair(6,7), "BLACK")
    }

    fun printBoard(){
        for(i in 0..7) {
            System.out.print("\n")
            for(j in 0..7) {
                System.out.print(board[i][j].getString())
            }
        }
    }


}



// Pieces
// ===============================


open class Piece(var pos: Pair<Int, Int>, val color : String){

    open fun legalMove(x: Int, y:Int) : Boolean {
        return false
    }
    open fun getPosition(): Pair<Int, Int> {
        return Pair(-1, -1)
    }
    open fun getString() : String {
        return ""
    }
}

class Empty(pos: Pair<Int, Int>, color: String) : Piece(pos, color) {
    override fun getString(): String {
        return " "
    }

    override fun getPosition(): Pair<Int, Int> {
        TODO("not implemented")
    }

    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
    }
}


class King(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "K"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}


class Queen(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "Q"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}


class Runner(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "R"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}


class Knight(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "Kn"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}


class Tower(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "T"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}


class Peasent(pos: Pair<Int, Int>, color: String) : Piece(pos, color)  {
    override fun getString(): String {
        return "P"
    }
    override fun getPosition(): Pair<Int, Int> {
        return Pair(pos.first, pos.second)
    }
    override fun legalMove(x: Int, y: Int): Boolean {
        TODO("not implemented")
        return false
    }
}

