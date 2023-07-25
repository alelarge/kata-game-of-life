import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAcceptanceTest {
    @Test
    fun any_living_cell_with_fewer_than_two_living_neighbors_dies_subpopulation() {
        val gameOfLife = GameOfLife(5, 5)
        gameOfLife.setCellState(1, 1, CellState.ALIVE)
        gameOfLife.nextGeneration()
        assertEquals(CellState.DEAD, gameOfLife.getCellState(1, 1))
/*
        val exception = assertThrows<IllegalArgumentException> { gameOfLife.nextGeneration()
*/
    }

    @Test
    fun any_living_cell_with_two_or_three_living_neighbors_survives() {

    }

    @Test
    fun any_living_cell_with_more_than_three_living_neighbors_dies_overpopulation() {
    }

    @Test
    fun any_dead_cell_with_exactly_three_living_neighbors_becomes_alive() {

    }

    @Test
    fun empty_grid() {

    }
}