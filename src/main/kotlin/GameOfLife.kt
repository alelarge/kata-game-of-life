class GameOfLife(private val rows: Int, private val cols: Int) {
    private val board = List(rows) { List(cols) { false } }

    fun isOver(): Boolean{
        return rows == 0 && cols == 0
    }

    fun isCellAlive(row: Int, col: Int, b: Boolean): Boolean {
        if (row <2){
            return false
        }
        return board[row][col]
    }


    fun isCellDead(deadCellRow: Int, deadCellCol: Int, b: Boolean): Boolean {
        return false
    }

}