import org.assertj.core.api.Assert
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
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
    fun empty_grid() {
        val numberOfRows = 0
        val numberOfCols = 0

        val game = GameOfLife(numberOfRows, numberOfCols)
        val grid = game.getGrid()

        for (row in grid) {
            for (cell in row) {
                assertNull(cell)
            }
        }
    }

    @Test
    fun alive_cells(){
        fun setAndGetCellState_return_good_state() {
            val numberOfRows = 4
            val numberOfCols = 4

            val game = GameOfLife(numberOfRows, numberOfCols)

            game.setCellState(1, 1, CellState.ALIVE)
            game.setCellState(1, 2, CellState.ALIVE)
            game.setCellState(1, 3, CellState.ALIVE)
            game.setCellState(2, 0, CellState.ALIVE)
            game.setCellState(2, 1, CellState.ALIVE)
            game.setCellState(2, 2, CellState.ALIVE)

            game.nextGeneration()
            assertEquals(CellState.DEAD, game.getCellState(1, 1))
            assertEquals(CellState.ALIVE, game.getCellState(1, 2))
            assertEquals(CellState.ALIVE, game.getCellState(1, 3))
            assertEquals(CellState.ALIVE, game.getCellState(2, 0))
            assertEquals(CellState.DEAD, game.getCellState(2, 1))
            assertEquals(CellState.ALIVE, game.getCellState(2, 2))

            game.nextGeneration()
            assertEquals(CellState.ALIVE, game.getCellState(1, 1))
            assertEquals(CellState.DEAD, game.getCellState(1, 2))
            assertEquals(CellState.ALIVE, game.getCellState(1, 3))
            assertEquals(CellState.ALIVE, game.getCellState(2, 0))
            assertEquals(CellState.ALIVE, game.getCellState(2, 1))
            assertEquals(CellState.ALIVE, game.getCellState(2, 2))
        }
    }
}

