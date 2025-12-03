fun main() {
    fun part1(input: List<String>): Long {
        var result: Long = 0
        input.forEach { productIds ->
            val (lower, upper) = getBounds(productIds)
            for (i in lower..upper) {
                sequenceIsRepeating(i.toString()).let {
                    result += it
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result: Long = 0
        input.forEach { productIds ->
            val (lower, upper) = getBounds(productIds)
            for (i in lower..upper) {
                sequenceIsRepeatingComplicated(i.toString()).let {
                    result += it
                }
            }
        }
        return result
    }

    val testInput = readLine("Day02_test")
    print("Test Input Part 1: ")
    part1(testInput).println()

    print("Test Input Part 2: ")
    part2(testInput).println()

    val input = readLine("Day02")
    print("Part 1: ")
    part1(input).println()

    print("Part 2: ")
    part2(input).println()
}

fun getBounds(input: String): Pair<Long, Long> {
    val temp = input.split("-")
    return temp[0].toLong() to temp[1].toLong()
}

fun sequenceIsRepeating(input: String): Long {
    val firstHalve = input.take(input.length / 2)
    val secondHalve = input.drop(input.length / 2)

    if (firstHalve == secondHalve) return input.toLong()

    return 0
}

fun sequenceIsRepeatingComplicated(input: String): Long {
    val values = input.toList()
    val maxIterations = if (input.length == 0) 1 else input.length - 1
    for(i in 0 until maxIterations) {
        val chunks = values.chunked(i + 1)
        if (chunks.toSet().size == 1) {
            return input.toLong()
        }
    }

    return 0
}
