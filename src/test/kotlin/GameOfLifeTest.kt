import org.junit.jupiter.api.Test


class GameOfLifeTest{
    @Test
    fun `create the grid`(){
        val gridCells :GridCells  = gridCellsOf(0 to 0, 0 to 1, 0 to 2)
    }
}

typealias GridCells = Set<Pair<Int,Int>>

private fun gridCellsOf(vararg liveCells: Pair<Int, Int>)= setOf(*liveCells)
}
