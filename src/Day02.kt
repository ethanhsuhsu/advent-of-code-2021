fun main() {
    fun part1(input: List<String>): Int {
        return input.fold(listOf(0, 0)) { a, s -> val x = s.takeLastWhile { it.isDigit() }.toInt()
            if (s[0] == 'f') listOf(a[0] + x, a[1]) else listOf(a[0], a[1] + if (s[0] == 'd') x else -x)
        }.let { it[0] * it[1] }
    }

    fun part2(input: List<String>): Int {
        return input.fold(listOf(0, 0, 0)) { a, s -> val x = s.takeLastWhile { it.isDigit() }.toInt()
            if (s[0] == 'f') listOf(a[0] + x, a[1] + x * a[2], a[2]) else listOf(a[0], a[1], a[2] + if (s[0] == 'd') x else -x)
        }.let { it[0] * it[1] }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
