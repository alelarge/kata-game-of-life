class GameOfLife(private val grid: Grid, private val initialLivingCellPositions: List<Pair<Int, Int>>){


    fun next() {
    }


    fun isCellDead(row: Int, col: Int): Boolean {
        return true
    }

    fun isOver(): Boolean {
        return true
    }
}

class Grid(private val rows: Int, private val cols: Int) {
    private var currentRow = 0
    private var currentCol = 0

    fun hasNext(): Boolean {
        return currentRow < rows && currentCol < cols
    }

    fun next(): Pair<Int, Int> {
        val position = Pair(currentRow, currentCol)

        currentCol++
        if (currentCol == cols) {
            currentCol = 0
            currentRow++
        }

        return position
    }

    fun getNeighbourPositions(row: Int, col: Int) {
    }

}

enum class CellState {
    ALIVE, DEAD
}

class Cell(private var state: CellState) {
    fun isAlive(): Boolean {
        return state == CellState.ALIVE
    }

    fun evolve(neighbours: List<Cell>) {
        val numNeighboursAlive = neighbours.count { it.isAlive() }

        state = when (state) {
            CellState.ALIVE -> {
                if (numNeighboursAlive < 2 || numNeighboursAlive > 3) {
                    CellState.DEAD
                } else {
                    CellState.ALIVE
                }
            }
            CellState.DEAD -> {
                if (numNeighboursAlive == 3) {
                    CellState.ALIVE
                } else {
                    CellState.DEAD
                }
            }
        }
    }
}