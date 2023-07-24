import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

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

    private companion object {
        private fun cellGridsOf(vararg liveCells: Pair<Int, Int>) = setOf(*liveCells)
    }

    @Test
    fun createCellsGrid() {
        val cellGrids: CellGrids = cellGridsOf(0 to 0, 0 to 1, 0 to 2)
    }

}

 fun CellGrids.step(): CellGrids = this

typealias CellGrids = Set<Pair<Int, Int>>

