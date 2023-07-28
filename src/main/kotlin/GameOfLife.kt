class GameOfLife(private val rows: Int, private val cols: Int) {
    private val board = List(rows) { MutableList(cols) { false } }

    fun isOver(): Boolean{
        return rows <0 && cols == 0
    }

    fun isCellAlive(row: Int, col: Int): Boolean {
        if (row <2){
            return false
        }
        return board[row][col]
    }


    fun isCellDead(row: Int, col: Int): Boolean {
        if (row <2){
            return true
        }
        return !board[row][col]
    }
}


