class Grid(private val rows: Int, private val cols: Int, gameState: List<List<Cell>>) {
    data class Position(var x: Int, var y: Int)

    private var currentPosition = Position(0, 0)

    val state = gameState

    fun hasNext(): Boolean {
        return currentPosition.x < rows && currentPosition.y < cols
    }

    fun next(): Position {
        val position = currentPosition.copy()

        currentPosition.y++
        if (currentPosition.y == cols) {
            currentPosition.y = 0
            currentPosition.x++
        }

        return position
    }


    fun getNeighbourPositions(position: Position, scale: Int): Set<Position> {
        val neighbourPositions = mutableSetOf<Position>()

        for (i in -1 * scale..scale) {
            for (j in -1 * scale..scale) {
                if (i == 0 && j == 0) continue
                val newX = position.x + i
                val newY = position.y + j
                if (newX in 0 until rows && newY in 0 until cols) {
                    neighbourPositions.add(Position(newX, newY))
                }
            }
        }
        return neighbourPositions
    }
}

enum class CellState {
    ALIVE, DEAD
}

class Cell(private var state: CellState) {
    private val neighbors = mutableListOf<Cell>()


    fun isAlive(): Boolean {
        return state == CellState.ALIVE
    }

    fun addNeighbor(neighbor: Cell) {
        neighbors.add(neighbor)
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