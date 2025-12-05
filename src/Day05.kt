fun main() {
    fun part1(input: List<List<String>>): Int {
        val freshIngrediantRanges = input.first().map {
            it.toRange("-")
        }

        val freshIngredients = input.last().filter { id ->
            freshIngrediantRanges.any { range ->
                id.toLong().isInRange(range)
            }
        }

        return freshIngredients.size
    }

    fun part2(input: List<List<String>>): Long {
        var result: Long = 0
        val allIngrediants = input.first()
            .map { it.toRange("-") }
            .sortedWith(compareBy({ it.first }, { it.last }))
            .toSet()
            .toList()
        flattenRanges(allIngrediants).map {
            result += getSizeOfRange(it)
        }

        return result
    }

    val testInput = readBlocks("Day05_test")

    check(part1(testInput) == 3)
    check(part2(testInput).toInt() == 14)

    print("Test Input Part 1: ")
    part1(testInput).println()
    print("Test Input Part 2: ")
    part2(testInput).println()


    val input = readBlocks("Day05")

    print("Part 1: ")
    part1(input).println()

    print("Part 2: ")
    part2(input).println()
}

fun flattenRanges(input: List<LongRange>): List<LongRange> {
    val result = mutableListOf<LongRange>()
    var currentRange = input.first()
    for (nextRange in input.drop(1)) {
        if (nextRange.first <= currentRange.last + 1) {
            currentRange = currentRange.first..maxOf(currentRange.last, nextRange.last)
        } else {
            result.add(currentRange)
            currentRange = nextRange
        }
    }

    result.add(currentRange)
    return result
}

fun getSizeOfRange(range: LongRange): Long {
    return range.last - range.first + 1
}




