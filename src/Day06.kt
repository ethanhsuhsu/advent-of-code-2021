fun main() {
    fun part1(input: List<String>): Int {
        return input[0].split(",").sumOf { listOf(1401, 1191, 1154, 1034, 950)[it.toInt() - 1] }
    }

    fun part2(input: List<String>): Long {
        return input[0].split(",").sumOf { listOf(6206821033, 5617089148, 5217223242, 4726100874, 4368232009)[it.toInt() - 1] }
    }

    /* for(n in 1..5) { hashMapOf(n to 1L).also { f -> repeat(256) { (f[0] ?: 0).also { for(i in 1..8) { f[i - 1] = f[i] ?: 0 } }
        .let { f[6] = (f[6] ?: 0) + it; f[8] = it } }.let { println("$n: ${f.values.sum()}") } } } */

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5934)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
