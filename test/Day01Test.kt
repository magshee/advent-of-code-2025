import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.*

class Day01Test {

    @ParameterizedTest
    @CsvSource(
        "50, LEFT, 50",
        "50, RIGHT, 50",
        "50, LEFT, 150",
        "50, RIGHT, 150",
    )
    fun `simple go to 0`(currentPosition: Int, direction: DIRECTION, steps: Int) {
        val (isAt0, _, newPosition) = goTo(currentPosition, direction, steps)
        assertEquals(1, isAt0)
        assertEquals(0, newPosition)
    }

    @ParameterizedTest
    @CsvSource(
       "50, LEFT, 68, 82, 1",
        "50, LEFT, 168, 82, 2",
        "95, RIGHT, 60, 55, 1",
        "95, RIGHT, 160, 55, 2"
    )
    fun `complex go to crossed 0`(currentPosition: Int, direction: DIRECTION, steps: Int, futurePosition: Int, expectedCrossesThrough0: Int) {
        val (isAt0, crossedZero, newPosition) = goTo(currentPosition, direction, steps)
        assertEquals(0, isAt0)
        assertEquals(expectedCrossesThrough0, crossedZero)
        assertEquals(futurePosition, newPosition)
    }

    @ParameterizedTest
    @CsvSource(
        "82, LEFT, 30, 52",
        "0, LEFT, 5, 95"
    )
    fun `complex go to does not cross 0`(currentPosition: Int, direction: DIRECTION, steps: Int, futurePosition: Int) {
        val (isAt0, crossedZero, newPosition) = goTo(currentPosition, direction, steps)
        assertEquals(0, isAt0, "should not land on 0")
        assertEquals(0, crossedZero, "should not have crossed 0")
        assertEquals(futurePosition, newPosition)
    }

   @ParameterizedTest
   @CsvSource(
       "50, LEFT, 150, 1",
       "50, RIGHT, 150, 1",
       "52, RIGHT, 48, 0"
   )
    fun `complex go to lands on 0`(currentPosition: Int, direction: DIRECTION, steps: Int, expectedCrossesThrough0: Int) {
        val (isAt0, crossedZero, newPosition) = goTo(currentPosition, direction, steps)
        assertEquals(1, isAt0)
        assertEquals(expectedCrossesThrough0, crossedZero)
        assertEquals(0, newPosition)
    }


    @ParameterizedTest
    @CsvSource(
        "50, RIGHT, 1000, 50, 10",
    )
    fun `complex go to lands not on 0`(currentPosition: Int, direction: DIRECTION, steps: Int, futurePosition: Int ,expectedCrossesThrough0: Int) {
        val (isAt0, crossedZero, newPosition) = goTo(currentPosition, direction, steps)
        assertEquals(0, isAt0)
        assertEquals(expectedCrossesThrough0, crossedZero)
        assertEquals(futurePosition, newPosition)
    }
}