import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.*

class Day04Test {

    @Test
    fun `get adjacent positions - start top leftmost`() {
        val grid = mutableListOf(
            mutableListOf('.', '@', '.'),
            mutableListOf('@', '@', '.')
        )
        val expected = mutableListOf('@', '@', '@')

        val currentPosition = Point(0, 0)

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start top rightmost`() {
        val grid = mutableListOf(
            mutableListOf('b', '@', 'a'),
            mutableListOf('c', '@', '@')
        )
        val expected = mutableListOf('@', '@', '@')

        val currentPosition = Point(2, 0)

        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start bottom leftmost`() {
        val grid = mutableListOf(
            mutableListOf('@', '@', 'b'),
            mutableListOf('a', '@', 'c')
        )
        val expected = mutableListOf('@', '@', '@')

        val currentPosition = Point(0, 1)
        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start bottom rightmost`() {
        val grid = mutableListOf(
            mutableListOf('b', '@', '@'),
            mutableListOf('c', '@', 'a')
        )
        val expected = mutableListOf('@', '@', '@')

        val currentPosition = Point(2, 1)

        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start top`() {
        val grid = mutableListOf(
            mutableListOf('@', 'a', '@'),
            mutableListOf('@', '@', '@')
        )
        val expected = mutableListOf('@', '@', '@', '@', '@')

        val currentPosition = Point(1, 0)
        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start left`() {
        val grid = mutableListOf(
            mutableListOf('@', '@', '@'),
            mutableListOf('a', '@', '@'),
            mutableListOf('@', '@', '@')
        )
        val expected = mutableListOf('@', '@', '@', '@', '@')

        val currentPosition = Point(0, 1)
        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }

    @Test
    fun `get adjacent positions - start right`() {
        val grid = mutableListOf(
            mutableListOf('d', '@', '@'),
            mutableListOf('b', '@', 'a'),
            mutableListOf('c', '@', '@')
        )
        val expected = mutableListOf('@', '@', '@', '@', '@')

        val currentPosition = Point(2, 1)
        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }


    @Test
    fun `get adjacent positions - middle`() {
        val grid = mutableListOf(
            mutableListOf('@', '@', '@'),
            mutableListOf('@', 'a', '@'),
            mutableListOf('@', '@', '@')
        )
        val expected = mutableListOf('@', '@', '@', '@', '@', '@', '@', '@')

        val currentPosition = Point(1, 1)
        assertEquals('a', grid[currentPosition.y][currentPosition.x])

        val result = getAdjacentFieldValues(currentPosition, grid)
        assertEquals(expected, result)
    }
}