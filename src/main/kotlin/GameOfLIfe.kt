interface CellState {
    fun isAlive(): Boolean
}

class AliveState : CellState {
    override fun isAlive() = true
}

class DeadState : CellState {
    override fun isAlive() = false
}

class Cell(private var state: CellState) {
    fun isAlive(): Boolean {
        return state.isAlive()
    }

    fun evolve(neighbours: List<Cell>) {
        val numNeighboursAlive = neighbours.count { it.isAlive() }

        state = if (state.isAlive()) {
            if (numNeighboursAlive < 2 || numNeighboursAlive > 3) {
                DeadState()
            } else {
                AliveState()
            }
        } else {
            if (numNeighboursAlive == 3) {
                AliveState()
            } else {
                DeadState()
            }
        }
    }
}

