import org.assertj.core.api.Assert
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

enum class CellState {
    DEAD,
    ALIVE
}

class GameOfLifeTest {
    @Test
    fun createGridInitialization() {
        val numberOfRows = 6
        val numberOfCols = 6
        val game = GameOfLife(numberOfRows, numberOfCols)

        val deadCellsInitialization = Array(numberOfRows) {
            Array(numberOfCols) {
                CellState.DEAD
            }
        }

        assertArrayEquals(deadCellsInitialization, game.getGrid())
    }

    @Test
    fun any_living_cell_with_fewer_than_two_living_neighbors_dies_subpopulation() {
        val gameOfLife = GameOfLife(5, 5)
        gameOfLife.setCellState(1, 1, CellState.ALIVE)
        gameOfLife.nextGeneration()
        assertEquals(CellState.DEAD, gameOfLife.getCellState(1, 1))
    }

}

