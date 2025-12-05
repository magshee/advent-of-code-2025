import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readText().trim().lines()

fun readGrid(name: String) = Path("src/$name.txt").readText().trim().lines().map { it.toList() }

fun readLine(name: String) = Path("src/$name.txt").readText().trim().split(",")

fun readBlocks(name: String) = Path("src/$name.txt").readText().trim().split("\n\n").map { it.lines() }

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Calculates the power of a long number without having to use floating point numbers
 */
fun Long.pow(exp: Int): Long {
    var result = 1L
    repeat(exp) { result *= this }
    return result
}

fun String.toRange(delimiter: String): LongRange {
    val split = this.split(delimiter)
    require(split.size >= 2) { "str must contain two integers separated by ;" }

    val (a, b) = split

    return try {
        a.toLong()..b.toLong()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("str values '$a' and/or '$b' are not integers", e)
    }
}

fun Long.isInRange(range: LongRange): Boolean {
    if (this >= range.first && this <= range.last) return true
    return false
}