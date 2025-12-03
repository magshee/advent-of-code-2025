import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.*

class Day02Test {

    @ParameterizedTest
    @ValueSource(longs = [11, 22, 99, 1010, 1188511885, 222222, 446446, 38593859])
    fun `invalid ids for one string`(input: Long) {
        val actual = sequenceIsRepeating(input.toString())
        assertEquals(input, actual)
    }

    @ParameterizedTest
    @ValueSource(longs = [12])
    fun `valids ids for one string`(input: Long) {
        val actual = sequenceIsRepeating(input.toString())
        assertEquals(0, actual)
    }

    @ParameterizedTest
    @ValueSource(longs = [11, 22, 99, 111, 999, 1010, 1188511885, 222222, 446446, 38593859, 565656, 824824824, 2121212121])
    fun `ids for one string more complicated`(input: Long) {
        val actual = sequenceIsRepeatingComplicated(input.toString())
        assertEquals(input, actual)
    }

    @ParameterizedTest
    @ValueSource(longs = [12, 23, 98, 112, 998, 1014, 1188511886, 222223, 446447, 38593857, 565655, 824824825, 2121212122])
    fun `valids ids for one string more complicated`(input: Long) {
        val actual = sequenceIsRepeatingComplicated(input.toString())
        assertEquals(0, actual)
    }
}