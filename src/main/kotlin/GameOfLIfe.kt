enum class CellState {
    ALIVE, DEAD
}
class GameOfLife(private val rows: Int, private val cols: Int) {
    fun isCellDead(row: Int, col: Int, b: Boolean) {

    }

    fun isOver(): Boolean {
        TODO("Not yet implemented")
    }

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
