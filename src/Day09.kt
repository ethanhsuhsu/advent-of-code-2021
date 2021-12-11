fun main() {
    fun part1(input: List<String>): Int {
        return input.indices.sumOf { r -> input[r].filterIndexed { i, h -> listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1 )
            .all { h < (input.getOrNull(r + it.first)?.getOrNull(i + it.second) ?: ':') } }.sumOf { it.digitToInt() + 1 } }
    }

    fun part2(input: List<String>): Int {
        return MutableList(input.size){ r -> MutableList(input[0].length){ c -> if(input[r][c] == '9') -1 else 0 } }.also { t ->
            var b = 0; t.indices.forEach { r -> t[0].indices.forEach { c -> if(t[r][c] == 0) { val n = (listOf(-1 to 0, 0 to -1, 1 to 0, 0 to 1 ).map {
            t.getOrNull(r + it.first)?.getOrNull(c + it.second) ?: 0 }.firstOrNull { it > 0 } ?: ++b).also{ t[r][c] = it }; listOf(-1 to 0,
            0 to -1, 1 to 0, 0 to 1 ).filter { (t.getOrNull(r + it.first)?.getOrNull(c + it.second) ?: -1) != -1}.forEach { val h =
                t[it.first + r][it.second + c]; if(h > 0 && h != n) t.indices.forEach { r -> t[0].indices.forEach { c -> if(t[r][c] == h) t[r][c] = n } } } } } } }
            .flatten().groupBy { it }.values.sortedByDescending { it.size }.filter { it[0] != -1 }.let {it[0].size * it[1].size * it[2].size}
    }
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day09_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 1134)

    val input = readInput("Day09")
    println(part1(input))
    println(part2(input))
}
