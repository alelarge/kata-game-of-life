class Game{
    constructor(
        grid: Grid,
        aliveCell : List<Position>
    ){
        this.grid = grid
        this.aliveCell = aliveCell
    }

    private val grid : Grid
    private var aliveCell : List<Position>

    //attribut global
    fun isOver() : Boolean {
        if (aliveCell.isEmpty()) {
            return true
        } else {
            return false
        }
    }
    fun play(){
        val aliveCellPositionForCurrentTurn : MutableList<Position> = mutableListOf()
        while(grid.hasNext()){
            val position = grid.next()
            val neighbour = grid.getNeighbourPositions(position,1).map { p -> getCellAtPosition(p)}
            val cell = getCellAtPosition(position)
            cell.evolve(neighbour)
            if(cell.isAlive()){
                aliveCellPositionForCurrentTurn.add(position)
            }
        }
        aliveCell = aliveCellPositionForCurrentTurn
    }
    private fun getCellAtPosition(position: Position): Cell{
        if(aliveCell.contains(position)){
            return Cell(CellState.ALIVE)
        } else {
            return Cell(CellState.DEAD)
        }
    }
}

