import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellTest {
    @Test
    fun `cell should be alive when initialized as alive`() {
        val aliveCell = Cell(AliveState())
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell should be dead when initialized as dead`() {
        val deadCell = Cell(DeadState())
        assertThat(deadCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has less than 2 live neighbors`() {
        val aliveCell = Cell(AliveState())
        val neighbours = listOf(Cell(AliveState()), Cell(DeadState()), Cell(DeadState()))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell dies when it has more than 3 live neighbors`() {
        val aliveCell = Cell(AliveState())
        val neighbours = listOf(Cell(AliveState()), Cell(DeadState()), Cell(DeadState()), Cell(DeadState()))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isFalse
    }

    @Test
    fun `cell stays alive when it has 2 live neighbors`() {
        val aliveCell = Cell(AliveState())
        val neighbours = listOf(Cell(AliveState()), Cell(AliveState()))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `cell stays alive when it has 3 live neighbors`() {
        val aliveCell = Cell(AliveState())
        val neighbours = listOf(Cell(AliveState()), Cell(AliveState()), Cell(AliveState()))
        aliveCell.evolve(neighbours)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell becomes alive when it has exactly three live neighbors`() {
        val deadCell = Cell(DeadState())
        val neighbours = listOf(Cell(AliveState()), Cell(AliveState()), Cell(AliveState()))
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell with three live neighbors becomes alive by reproduction`(){
        val deadCell = Cell(DeadState())
        val neighbours = listOf(Cell(AliveState()), Cell(AliveState()), Cell(AliveState()))
        deadCell.evolve(neighbours)
        assertThat(deadCell.isAlive()).isTrue
    }
}
