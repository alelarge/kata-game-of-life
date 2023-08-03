import com.sun.org.apache.xpath.internal.operations.Bool
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `alive cell`(){
        val aliveCell = Cell(state = true)
        assertThat(aliveCell.isAlive()).isTrue
    }

    @Test
    fun `dead cell`(){
        val deadCell = Cell(state = false)
        assertThat(deadCell.isAlive()).isFalse
    }
    @Test
    fun `when i have alive cell if moins de 2 voisins elles meurent`(){
       val aliveCell = Cell(state=true)
       val neighbour = listOf(Cell(state=true), Cell(state = false), Cell(state=false))
        aliveCell.Evolue(neighbour)
        assertThat(aliveCell.isAlive()).isFalse
    }
}

class Cell {
    //attribut stocke informations objets
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
        if(numberNeighbour<2){
            state = false
        }
    }
}
