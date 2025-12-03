import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.*

class Day03Test {

    @ParameterizedTest()
    @CsvSource(
        "111111111111111, 11",
        "811111111111119, 89",
        "811111111111189, 89",
        "981111111111187, 98",
        "987654321111111, 98",
        "234234234234278, 78",
        "818181911112111, 92"
    )
    fun `get joltage - fixed battery input (2)`(input: String, expected: Long) {
        val result = getJoltage(input, 2)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "1192, 9",
        "1111, 1",
        "1189, 8",
        "19, 9",
        "9182, 9"
    )
    fun `get highest number`(input: String, expected: Int) {
        val result = getHighestNumber(input,2)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "1192, 9, 2",
    )
    fun `update available batteries`(input: String, from: Int, expected: String) {
        val result = updateAvailableBatteries(input, from)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
        "0, 1, 0",
        "1192, 4, 1192",
        "1192, 1, 9",
        "1192, 2, 92",
        "11921, 2, 92",
        "11912, 2, 92",
        "11912, 3, 912",
        "119123, 4, 9123",
        "987654321111111, 12, 987654321111",
        "811111111111119, 12, 811111111119",
        "234234234234278, 12, 434234234278",
        "818181911112111, 12, 888911112111"
    )
    fun `get jotable - variable battery input`(input: String, batteries: Int , expected: Long) {
        val result = getJoltage(input, batteries)
        assertEquals(expected, result)
    }
}