import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled

class TestAcceptanceTest {
    @Test
    fun any_living_cell_with_fewer_than_two_living_neighbors_dies_subpopulation() {
        steps("""
        ┌─────┐
        │  o  │
        └─────┘
        """,
        """
        ┌─────┐
        │     │
        └─────┘
        """)
    }

    @Test
    @Disabled
    fun any_living_cell_with_two_or_three_living_neighbors_survives() {
    }


    @Test
    @Disabled
    fun any_living_cell_with_more_than_three_living_neighbors_dies_overpopulation() {
    }

    @Test
    @Disabled
    fun any_dead_cell_with_exactly_three_living_neighbors_becomes_alive() {

    }
}


fun steps(initial: String, expected: String) {
    assertThat(false).isEqualTo(true)
}
