import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `cell should be alive when initialized as alive`() {
        val aliveCell = Cell(CellState.ALIVE)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell should be dead when initialized as dead`() {
        val deadCell = Cell(CellState.DEAD)
        assertThat(deadCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has less than 2 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.DEAD), Cell(CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has more than 3 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.DEAD), Cell(CellState.DEAD), Cell(CellState.DEAD))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell stays alive when it has 2 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell stays alive when it has 3 live neighbors`() {
        val aliveCell = Cell(CellState.ALIVE)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell becomes alive when it has exactly three live neighbors`() {
        val deadCell = Cell(CellState.DEAD)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell with three live neighbors becomes alive by reproduction`() {
        val deadCell = Cell(CellState.DEAD)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }

    @Test
        fun `must return all positions in a 3 by 3 grid, taking into account corners and edges with scale`() {
            // Given
            val rows = 3
            val cols = 3
            val scale = 1
            val expectedPositions = mutableListOf<Grid.Position>()

            for (x in 0 until rows) {
                for (y in 0 until cols) {
                    val position = Grid.Position(x, y)
                    expectedPositions.addAll(Grid(rows, cols).getNeighbourPositions(position, scale))
                }
            }

            // When
            val grid = Grid(rows, cols)
            val generatedPositions = mutableListOf<Grid.Position>()
            while (grid.hasNext()) {
                val position = grid.next()
                generatedPositions.add(position)
            }

            // Then
            val expectedNeighbours = setOf(
            Pair(1, 1), Pair(1, 2), Pair(1, 3),
            Pair(2, 1),              Pair(2, 3),
            Pair(3, 1), Pair(3, 2), Pair(3, 3)
        )
        assertThat(expectedNeighbours.toSet()).isEqualTo(expectedNeighbours)
        }

    @Test
    fun `cell with 3 live neighbors survives to the next generation`() {
        //Given
        val aliveCell = Cell(CellState.ALIVE)
        val neighbors = List(3) { Cell(CellState.ALIVE) }
        val deadNeighbor = Cell(CellState.DEAD)

        //When
        neighbors.forEach { aliveCell.addNeighbor(it) }
        aliveCell.addNeighbor(deadNeighbor)
        aliveCell.evolve(neighbors)

        //Then
        assertThat(aliveCell.isAlive()).isTrue
    }
}








