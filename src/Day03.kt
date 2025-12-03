import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Long {
        var result: Long = 0
        input.forEach { bank ->
            result += getJoltage(bank, 2)
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result: Long = 0
        input.forEach { bank ->
            val res = getJoltage(bank, 12)
            result += res
        }
        return result
    }

    val testInput = readInput("Day03_test")

    check(part1(testInput) == 357.toLong())
    check(part2(testInput) == 3121910778619)

    print("Test Input Part 1: ")
    part1(testInput).println()
    print("Test Input Part 2: ")
    part2(testInput).println()


    val input = readInput("Day03")

    print("Part 1: ")
    part1(input).println()

    print("Part 2: ")
    measureTimeMillis {
        part2(input).println()
    }.let {
        println("took $it ms")
    }
}

fun getJoltage(input: String, batteries: Int): Long {
    if (batteries == 0) return 0
    if (batteries == input.length) return input.toLong()

    val highestNumber = getHighestNumber(input,batteries)

    return (highestNumber * 10L.pow(batteries - 1)) + getJoltage(
        updateAvailableBatteries(
            input,
            highestNumber
        ), batteries - 1
    )
}

fun getHighestNumber(input: String, latestBatteryPosition: Int): Int {
    if (input.length > latestBatteryPosition) {
        return input.dropLast(latestBatteryPosition - 1).maxOfOrNull { it.digitToInt() } ?: return 0
    } else {
        return input.maxOfOrNull { it.digitToInt() } ?: return 0
    }
}

fun updateAvailableBatteries(input: String, from: Int): String {
    val index = input.indexOf(from.toString())
    return input.drop(index + 1)
}
