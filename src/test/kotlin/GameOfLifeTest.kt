import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
enum class CellState {
    DEAD,
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
}
