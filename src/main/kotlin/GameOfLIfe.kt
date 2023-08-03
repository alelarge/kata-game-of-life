
class Cell {
    //attribut stocke information objets
    var state: Boolean

    //parametre state ligne en dessous
    constructor(state: Boolean) {
        this.state = state
        // attribut this.state
        // attribut rajouter this
    }

    fun isAlive(): Boolean {
        if (state == false) {
            return false
        } else {
            return true
        }
    }
    fun Evolue(neighbour: List<Cell>){
        val numberNeighbour= neighbour.count {
            it.isAlive()
        }
        if(numberNeighbour<2 || numberNeighbour>3){
            state = false
        } else {
            state = true
        }
    }
}
