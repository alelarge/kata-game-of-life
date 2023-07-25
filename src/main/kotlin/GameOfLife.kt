class GameOfLife(private val rows: Int, private val cols: Int) {
    private val board = List(rows) { List(cols) { false } }

    fun isOver(): Boolean{
        return true
    }

    fun isCellAlive(row:Int, col: Int): Boolean {
        if (row <2){
            return true
        }
        return board[row][col]
    }
}