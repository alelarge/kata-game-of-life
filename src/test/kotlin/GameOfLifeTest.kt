import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `when i have no alive and dead cells, return game over`() {
        //given
        val numberOfRows = 0
        val numberOfCols = 0
        val game = GameOfLife(numberOfRows, numberOfCols)

        //when
        val gameOver = game.isOver()

        //then
        assertThat(true).isEqualTo(gameOver)
    }

    @Test
    fun `when i have a board 5-5, alive cells 2-2 return game over`(){
        //given
      val game = GameOfLife(5,5)

        //when
        val aliveCellRow = 2
        val aliveCellCol = 2

        //then
        val isGameOver = !game.isCellAlive(aliveCellRow, aliveCellCol)

        assertThat(true).isEqualTo(isGameOver)
    }
}