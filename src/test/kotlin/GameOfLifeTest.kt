import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class GameOfLifeTest {
/*
    private lateinit var game: GameOfLife
*/

  /*  @BeforeEach
    fun config() {
        game = GameOfLife(8, 8)
    }*/

    @Test
    fun createGridInitialization() {
        val numberOfRows = 8
        val numberOfCols = 8
        val game = GameOfLife(numberOfRows,numberOfCols)
/*
        val deadCellsInitialization = Array(numberOfRows) {BooleanArray(numberOfCols) {false}}
*/
        val deadCellsInitialization = arrayOf(
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false ),
            arrayOf(false, false, false, false, false,false, false, false )

        )
        assertArrayEquals(deadCellsInitialization, game.getGrid())
        }
    }

        /* val deadCellsInitialization = arrayOf(
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
             booleanArrayOf(false, false, false, false, false, false, false, false),
         )*/

       /* val numberOfRows = 8
        val numberOfCols = 8*/
    /*    val game = GameOfLife(numberOfRows, numberOfCols)

        assertEquals(numberOfRows, game.getGrid().size)
        assertEquals(numberOfCols, game.getGrid()[0].size)
        assertEquals(Array(numberOfRows){BooleanArray(numberOfCols)}, game.getGrid())*/
/*
        val gridCells :GridCells= gridCellsOf(0 to 0, 0 to 1, 0 to 2)
*/

/*
typealias GridCells = Set<Pair<Int,Int>>
*/

/*
private fun gridCellsOf(vararg liveCells: Pair<Int, Int>)= setOf(*liveCells)
*/

