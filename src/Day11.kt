fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.map { it.digitToInt() }.toMutableList() }.toMutableList().let { d ->
            var f = 0; repeat(100) { d.indices.forEach { r -> d[0].indices.forEach { c -> d[r][c] += 1 } }
            while (true) if (d.indices.all { r -> d[0].indices.all { c -> if (d[r][c] > 9) repeat(9) { i ->
                            if ((d.getOrNull(r - 1 + i / 3)?.getOrNull(c - 1 + i % 3) ?: 0) > 0) d[r - 1 + i / 3][c - 1 + i % 3]++
                        }.let { d[r][c] = ++f - f; false } else true } }) break }; f }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.map { it.digitToInt() }.toMutableList() }.toMutableList().let { d ->
            var f = 0; while(!d.flatten().all { it == 0 }) { d.indices.forEach { r -> d[0].indices.forEach { c -> d[r][c] += 1 } }
            while (true) if (d.indices.all { r -> d[0].indices.all { c -> if (d[r][c] > 9) repeat(9) { i ->
                    if ((d.getOrNull(r - 1 + i / 3)?.getOrNull(c - 1 + i % 3) ?: 0) > 0) d[r - 1 + i / 3][c - 1 + i % 3]++
                }.let { d[r][c] = 0; false } else true } }) break; f++ }; f }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day11_test")
    check(part1(testInput) == 1656)
    check(part2(testInput) == 195)

    val input = readInput("Day11")
    println(part1(input))
    println(part2(input))
}
