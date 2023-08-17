import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import javax.swing.text.Position
import kotlin.test.assertEquals

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
    fun `should generate all positions in a 3 by 3 grid`() {
        // Given
        val rows = 3
        val cols = 3
        val expectedPositions = listOf(
            Pair(0, 0), Pair(0, 1), Pair(0, 2),
            Pair(1, 0), Pair(1, 1), Pair(1, 2),
            Pair(2, 0), Pair(2, 1), Pair(2, 2)
        )

        // When
        val grid = Grid(rows, cols)
        val generatedPositions = mutableListOf<Pair<Int, Int>>()
        while (grid.hasNext()) {
            val position = grid.next()
            generatedPositions.add(position)
        }

        // Then
        assertThat(generatedPositions).containsExactlyElementsOf(expectedPositions)
    }

    @Test
    fun `get neighbour positions for a position in the center`() {
        val grid = Grid(5, 5)
        val neighbours = grid.getNeighbourPositions(2, 2)
        val expectedNeighbours = setOf(
            Pair(1, 1), Pair(1, 2), Pair(1, 3),
            Pair(2, 1),              Pair(2, 3),
            Pair(3, 1), Pair(3, 2), Pair(3, 3)
        )
        assertThat(neighbours.toSet()).isEqualTo(expectedNeighbours)
    }

    @Test
    fun `must return all positions in a 3 by 3 grid, taking into account corners and edges`() {
        // Given
        val rows = 3
        val cols = 3
        val expectedPositions = listOf(
            Position(0, 0), Position(0, 1), Position(0, 2),
            Position(1, 0), Position(1, 1), Position(1, 2),
            Position(2, 0), Position(2, 1), Position(2, 2)
        )

        // When
        val grid = Grid(rows, cols)
        val generatedPositions = mutableListOf<Position>()
        while (grid.hasNext()) {
            val position = grid.next()
            generatedPositions.add(position)
        }

        // Then
        assertEquals(expectedPositions, generatedPositions)
    }
}








