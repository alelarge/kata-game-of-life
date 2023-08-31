class Grid(private val rows: Int, private val cols: Int) {
    private var currentPosition = Position(0, 0)

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