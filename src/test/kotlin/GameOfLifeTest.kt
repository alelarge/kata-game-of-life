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
    fun `given a 5 by 5 game and cell 2,2 is alive, then the game is not over`(){
        //given
        val game = GameOfLife(5,5)
        val aliveCellRow = 2
        val aliveCellCol = 2

        //when

        game.isCellAlive(aliveCellRow, aliveCellCol, true)

        //then
        val gameOver = game.isOver()

        assertThat(false).isEqualTo(gameOver)
    }
}