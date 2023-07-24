enum class CellState {
    DEAD,
    ALIVE,
}

class GameOfLife(private val rows: Int, private val cols: Int) {
    private var grid = Array(rows) {
        Array(cols) {
            CellState.DEAD
        }
    }

    fun setCellState(row: Int, column: Int, state: CellState) {
        grid[row][column] = state
    }

    fun nextGeneration() {
        val newGrid = Array(rows) { Array<CellState>(cols) { CellState.DEAD } }

        for (row in 0 until rows) {
            for (column in 0 until cols) {
                val aliveNeighbors = countAliveNeighbors(row, column)
                newGrid[row][column] = when (grid[row][column]) {
                    CellState.ALIVE -> {
                        if (aliveNeighbors < 2) CellState.DEAD
                        else CellState.ALIVE
                    }
                    CellState.DEAD -> CellState.DEAD
                }
            }
        }

        grid = newGrid
    }

    private fun countAliveNeighbors(row: Int, column: Int): Int {
        return 0
    }

    fun getCellState(row: Int, column: Int): CellState {
        return grid[row][column]
    }

    fun getGrid(): Array<Array<CellState>> {
        return grid
    }

    fun isEmptyGrid(): Boolean {
        return grid.all { row -> row.all { cell -> cell == null} }

    }
}
