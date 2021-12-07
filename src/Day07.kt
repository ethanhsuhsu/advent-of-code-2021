import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input[0].split(",").map(String::toInt).let { c -> (c.minOf { it }..c.maxOf { it }).minOf { i -> c.sumOf { abs(it - i) } } }
    }

    fun part2(input: List<String>): Int {
        return input[0].split(",").map(String::toInt).let { c -> (c.minOf { it }..c.maxOf { it }).minOf { i -> c.sumOf { abs(it - i)*(abs(it - i)+1)/2 } } }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}
