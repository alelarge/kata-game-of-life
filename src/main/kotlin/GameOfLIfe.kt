interface CellState {
    fun isAlive(): Boolean
    fun evolve(neighbours: List<Cell>): CellState
}

class AliveState : CellState {
    override fun isAlive() = true

    override fun evolve(neighbours: List<Cell>): CellState {
        val numNeighboursAlive = neighbours.count { it.state.isAlive() }
        return if (numNeighboursAlive < 2 || numNeighboursAlive > 3) {
            DeadState()
        } else {
            AliveState()
        }
    }
}

class DeadState : CellState {
    override fun isAlive() = false

    override fun evolve(neighbours: List<Cell>): CellState {
        val numNeighboursAlive = neighbours.count { it.state.isAlive() }
        return if (numNeighboursAlive == 3) {
            AliveState()
        } else {
            DeadState()
        }
    }
}

class Cell(var state: CellState) {
    fun isAlive(): Boolean {
        return state.isAlive()
    }

    fun evolve(neighbours: List<Cell>) {
        state = state.evolve(neighbours)
    }
}
