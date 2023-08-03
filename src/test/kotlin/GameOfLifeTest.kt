import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `alive cell`() {
        val aliveCell = Cell(state = true)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell`() {
        val deadCell = Cell(state = false)
        assertThat(deadCell.isAlive()).isFalse
    }

    @Test
    fun `when i have alive cell less than 2 neighbors they die`() {
        val aliveCell = Cell(state = true)
        val neighbour = listOf(Cell(state = true), Cell(state = false), Cell(state = false))
        aliveCell.Evolue(neighbour)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `if more than 3 neighbors, the cell dies`(){
        val aliveCell = Cell(state = true)
        val neighbour = listOf(Cell(state = true), Cell(state = false), Cell(state = false), Cell(state = false))
        aliveCell.Evolue(neighbour)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `if 2 I stay alive`() {
        val aliveCell = Cell(state = true)
        val neighbour = listOf(Cell(state = true), Cell(state = true))
        aliveCell.Evolue(neighbour)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `if 3 I stay alive`() {
        val aliveCell = Cell(state = true)
        val neighbour = listOf(Cell(state = true), Cell(state = true), Cell(state = true))
        aliveCell.Evolue(neighbour)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
        fun `if a dead cell has exactly three neighbors, it must live`() {
          val aliveCell = Cell(state=false)
          val neighbour = listOf(Cell(state=true), Cell(state=true), Cell(state=true))
          aliveCell.Evolue(neighbour)
          assertThat(aliveCell.isAlive()).isTrue
        }
}
