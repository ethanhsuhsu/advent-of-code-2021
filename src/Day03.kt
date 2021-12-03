fun main() {
    fun part1(input: List<String>): Int {
        return input.fold(List(input[0].length) { 0 }) { a, s -> a.mapIndexed { i, j -> j + s[i].digitToInt() } }
            .map { if (0 < it - input.size / 2.0) 1 else 0 }.joinToString("").let { it.toInt(2) *
                    it.replace('0', '2').replace('1', '0').replace('2', '1').toInt(2) }
    }

    fun part2(input: List<String>): Int {
        return listOf<(Double, Double) -> Boolean>({ a, b -> a <= b }, { a, b -> a > b }).map {
            input.toMutableList().also { l -> for (i in input[0].indices) (if (it(0.0, l.count { it[i] == '1' } - l.size / 2.0)) 1 else 0)
                    .digitToChar().let { m -> l.removeAll { l.size > 1 && it[i] != m } } }[0].toInt(2) }.let { it[0] * it[1] }
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
