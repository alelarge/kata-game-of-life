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
    fun `dead cell with three live neighbors becomes alive by reproduction`(){
        val deadCell = Cell(CellState.DEAD)
        val neighbours = listOf(Cell(CellState.ALIVE), Cell(CellState.ALIVE), Cell(CellState.ALIVE))
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }



    @Test
    fun `given a 5 by 5 game and cell 2,2 is dead, then the game is over`(){
        //given
        val game = GameOfLife(5,5)
        val deadCellRow = 2
        val deadCellCol = 2

        //when
        game.isCellDead(deadCellRow, deadCellCol, true)

        //then
        val isGameOver = game.isOver()

        assertThat(true).isEqualTo(isGameOver)
    }
        @Test
        fun `should return all positions in 3-3 grid`() {
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
}

