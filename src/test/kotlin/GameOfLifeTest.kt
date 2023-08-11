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
}

private fun Unit.toSet() {

}

/*    @Test
    fun `update cell states correctly according to the initial positions of living cells`() {
        // Given
        val rows = 3
        val cols = 3
        val initialLivingCellPositions = listOf(Pair(0, 0), Pair(1, 1))
        val grid = Grid(rows, cols)
        val game = GameOfLife(grid, initialLivingCellPositions)

        // When
        game.nextTurn()

        //Then
        assertThat(grid.getCell(0, 0).isAlive()).isTrue
        assertThat(grid.getCell(1, 1).isAlive()).isTrue
        assertThat(grid.getCell(0, 1).isAlive()).isFalse
    }


}*/

/* @Test
 fun `update cell states correctly according to the initial positions of living cells`() {
     // Given
     val rows = 3
     val cols = 3
     val initialLivingCellPositions = listOf(Pair(0, 0), Pair(1, 1))
     val grid = Grid(rows, cols)
     val neighbourPositions = calculateNeighbourPositions(initialLivingCellPositions)

     val game = GameOfLife(grid, initialLivingCellPositions, neighbourPositions)

     // When
     game.nextTurn()

     // Then
     assertThat(game.isCellDead(0, 0)).isFalse
     assertThat(game.isCellDead(1, 1)).isFalse
     assertThat(game.isCellDead(0, 1)).isTrue
 }*/









