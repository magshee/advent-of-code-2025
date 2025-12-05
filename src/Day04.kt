fun main() {
    fun part1(input: List<List<Char>>): Long {
        var result: Long = 0

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] != '@') continue
                val adjacentValues = getAdjacentFieldValues(Point(x, y), input).filter {
                    it == '@'
                }
                if(paperRollIsAccessible(adjacentValues.size, 3)) {
                    result += 1
                }
            }
        }

        return result
    }

    fun part2(input: List<List<Char>>): Long {
        var result: Long = 0
        var paperRollWasPickedUp = true

        val cleanableGrid = input.map {
            it.toMutableList()
        }.toMutableList()
        var i = 1000
        createPlotFor(cleanableGrid, i)
        while(paperRollWasPickedUp) {
            var intermediateResult: Long = 0
            for (y in cleanableGrid.indices) {
                for (x in cleanableGrid[y].indices) {
                    if (cleanableGrid[y][x] != '@') continue
                    val adjacentValues = getAdjacentFieldValues(Point(x, y), cleanableGrid).filter {
                        it == '@'
                    }
                    if (paperRollIsAccessible(adjacentValues.size, 3)) {
                        cleanableGrid[y][x] = '.'
                        intermediateResult += 1
                    }
                }
            }
            if (intermediateResult == 0L){
                paperRollWasPickedUp = false
            } else {
                result += intermediateResult
            }
            i += 1
            createPlotFor(cleanableGrid, i)
        }

        return result
    }

    val testInput = readGrid("Day04_test")

    check(part1(testInput) == 357.toLong())
    check(part2(testInput) == 3121910778619)

    print("Test Input Part 1: ")
    part1(testInput).println()
    print("Test Input Part 2: ")
    part2(testInput).println()


    val input = readGrid("Day04")

    print("Part 1: ")
    part1(input).println()

    print("Part 2: ")
    part2(input).println()
}

fun getAdjacentFieldValues(currentPosition: Point, field: List<List<Char>>): List<Char> {
    val maxY = field.size - 1
    val maxX = field[0].size - 1
    val values = mutableListOf<Char>()

    if (currentPosition.y > 0) {
        values.add(field[currentPosition.y - 1][currentPosition.x])
    }

    if (currentPosition.x > 0) {
        values.add(field[currentPosition.y][currentPosition.x - 1])
    }

    if (currentPosition.y < maxY) {
        values.add(field[currentPosition.y + 1][currentPosition.x])
    }
    if (currentPosition.x < maxX) {
       values.add(field[currentPosition.y][currentPosition.x + 1])
    }
    if (currentPosition.y < maxY && currentPosition.x < maxX) {
        values.add(field[currentPosition.y + 1][currentPosition.x + 1])
    }

    if (currentPosition.y < maxY && currentPosition.x > 0) {
        values.add(field[currentPosition.y + 1][currentPosition.x - 1])
    }

    if (currentPosition.y > 0 && currentPosition.x < maxX) {
        values.add(field[currentPosition.y - 1][currentPosition.x + 1])
    }

    if (currentPosition.y > 0 && currentPosition.x > 0) {
        values.add(field[currentPosition.y - 1][currentPosition.x - 1])
    }

    return values
}

fun paperRollIsAccessible(amount: Int, maxAmount: Int): Boolean {
    val result =  amount <= maxAmount
    return result
}

data class Point(
    val x: Int,
    val y: Int
)