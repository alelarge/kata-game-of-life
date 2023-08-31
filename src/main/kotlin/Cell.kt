class Cell(private var cellState: CellState) {
    private val neighbors = mutableListOf<Cell>()

    private var state = cellState

    fun getState(): CellState {
        return state
    }

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