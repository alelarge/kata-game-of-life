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

    fun isEmptyGrid(): Boolean {
        return grid.all { row -> row.all { cell -> cell == CellState.DEAD } }
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
                        if (aliveNeighbors < 2 || aliveNeighbors > 3) CellState.DEAD
                        else CellState.ALIVE
                    }

                    CellState.DEAD -> {
                        if (aliveNeighbors == 3) CellState.ALIVE
                        else CellState.DEAD
                    }
                }
            }
        }

        grid = newGrid
    }

    private fun countAliveNeighbors(row: Int, column: Int): Int {
        var aliveCount = 0

        for (i in -1..1) {
            for (j in -1..1) {
                if (i == 0 && j == 0) continue // Skip the center cell
                val newRow = row + i
                val newColumn = column + j
                if (newRow in 0 until rows && newColumn in 0 until cols) {
                    if (grid[newRow][newColumn] == CellState.ALIVE) {
                        aliveCount++
                    }
                }
            }
        }

        return aliveCount
    }

    fun getCellState(row: Int, column: Int): CellState {
        return grid[row][column]
    }

    fun getGrid(): Array<Array<CellState>> {
        return grid
    }
}


