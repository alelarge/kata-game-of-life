enum class CellState {
    DEAD,
}

class GameOfLife(private val rows: Int, private val cols: Int) {
    private val grid = Array(rows) {
        Array(cols) {
            CellState.DEAD
        }
    }

    fun getGrid(): Array<Array<CellState>> {
        return grid
    }
}
