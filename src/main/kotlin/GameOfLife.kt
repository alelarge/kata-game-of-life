class GameOfLife(private val numberOfRows: Int, private val numberOfCols:Int){
    private val grid: Array<Array<Boolean>> = Array(numberOfRows) {Array(numberOfCols) {false}}

    fun getGrid(): Array<Array<Boolean>> {
        return grid
    }
}
