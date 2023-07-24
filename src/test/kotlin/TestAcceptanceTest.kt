import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAcceptanceTest {
    @Test
    fun any_living_cell_with_fewer_than_two_living_neighbors_dies_subpopulation() {
        val gameOfLife = GameOfLife(5, 5)
        gameOfLife.setCellState(1, 1, CellState.ALIVE)
        gameOfLife.nextGeneration()
        assertEquals(CellState.DEAD, gameOfLife.getCellState(1, 1))
    }
}