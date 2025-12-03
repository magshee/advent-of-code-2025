import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var position = 50
        var isAt0 = 0

        input.forEach { instruction ->
            val (direction, steps) = parseInstruction(instruction)
            when (direction) {
                DIRECTION.LEFT -> {
                   val result = goTo(position, direction, steps)
                   isAt0 += result.first
                   position = result.third
                }
                DIRECTION.RIGHT -> {
                    val result = goTo(position, direction, steps)
                    isAt0 += result.first
                    position = result.third
                }
            }
        }

        return isAt0
    }

    fun part2(input: List<String>): Int {
        var position = 50
        var at0 = 0
        var crossedZero = 0

        input.forEach { instruction ->
            val (direction, steps) = parseInstruction(instruction)
            when (direction) {
                DIRECTION.LEFT -> {
                    val result = goTo(position, direction, steps)
                    at0 += result.first
                    crossedZero += result.second
                    position = result.third
                }
                DIRECTION.RIGHT -> {
                    val result = goTo(position, direction, steps)
                    at0 += result.first
                    crossedZero += result.second
                    position = result.third
                }
            }
        }
        return at0 + crossedZero
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)
    print("Test Input Part 1: ")
    part1(testInput).println()
    print("Test Input Part 2: ")
    part2(testInput).println()

    val input = readInput("Day01")
    print("Part 1: ")
    part1(input).println()
    print("Part 2: ")
    part2(input).println()
}

fun parseInstruction(instruction: String): Pair<DIRECTION, Int> {
    val (first, steps) = instruction.splitAtIndex(1)
    if (first == "L") {
        return Pair(DIRECTION.LEFT, steps.toInt())
    } else {
        return Pair(DIRECTION.RIGHT, steps.toInt())
    }
}

fun goTo(from: Int, direction: DIRECTION, steps: Int): Triple<Int, Int, Int> {
    var isAt0 = 0
    var crossedZero = 0
    var newPosition = from

    when(direction) {
        DIRECTION.LEFT -> {
            newPosition = from - steps
            if (newPosition < 0) {
                crossedZero += abs(newPosition) / 100 + 1
                newPosition += 100 * crossedZero
                if (newPosition % 100 == 0 || from == 0) {
                    crossedZero -= 1
                }
            }
            if (abs(newPosition) % 100 == 0) {
                newPosition = 0
                isAt0 += 1
            }
        }
        DIRECTION.RIGHT -> {
            newPosition = from + steps
            if (newPosition >= 100) {
                crossedZero += newPosition / 100
                newPosition -= 100 * crossedZero
                if (newPosition % 100 == 0) {
                    crossedZero -= 1
                }
            }
            if (newPosition % 100 == 0) {
                newPosition = 0
                isAt0 += 1
            }

        }
    }


    return Triple(isAt0, crossedZero, newPosition)
}

fun String.splitAtIndex(index: Int) = when {
    index < 0 -> 0
    index > length -> length
    else -> index
}.let {
    take(it) to substring(it)
}

enum class DIRECTION {
    LEFT,
    RIGHT
}