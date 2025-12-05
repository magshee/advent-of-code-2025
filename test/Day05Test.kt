import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.math.max
import kotlin.math.min
import kotlin.test.*

class Day05Test {

    @Test
    fun `parse Integer range`() {
        val input = "10-20"
        val actual = input.toRange("-")
        val expected = 10L..20L
        assertEquals(expected,actual)
    }

    @ParameterizedTest
    @CsvSource(
        "10, 10-20, true",
        "9, 10-123, false",
        "24, 3-20, false"
    )
    fun `check if value is in range`(value: Long, rawRange: String, expected: Boolean) {
        val range = rawRange.toRange("-")
        assertEquals(expected, value.isInRange(range))
    }

    @Test
    fun `flatten ranges - simple input`() {
        val input = listOf(
            "10-20",
            "20-30"
        ).map { it.toRange("-") }.sortedBy { it.first}
        assertEquals(listOf(10L..30L), flattenRanges(input))
    }

    @Test
    fun `flatten ranges - input overlaps`() {
        val input = listOf(
            "10-20",
            "15-30"
        ).map { it.toRange("-") }.sortedBy { it.first}
        assertEquals(listOf(10L..30L), flattenRanges(input))
    }

    @Test
    fun `flatten ranges - ranges are distinct`() {
        val input = listOf(
            "10-20",
            "25-30"
        ).map { it.toRange("-") }.sortedBy { it.first}

        val expected = listOf(
            10L..20L,
            25L..30L
        )
        assertEquals(expected, flattenRanges(input))
    }

    @Test
    fun `flatten ranges - continue with next entry`() {
        val input = listOf(
            "10-20",
            "25-30",
            "30-40"
        ).map { it.toRange("-") }.sortedBy { it.first}

        val expected = listOf(
            10L..20L,
            25L..40L
        )
        assertEquals(expected, flattenRanges(input))
    }

    @Test
    fun `flatten ranges - multiple actions required`() {
        val input = listOf(
            "3-5",
            "10-14",
            "16-20",
            "12-18"
        ).map { it.toRange("-") }.sortedBy { it.first}

        val expected = listOf(
            "3-5",
            "10-20",
        ).map { it.toRange("-")}
        assertEquals(expected, flattenRanges(input))
    }
}