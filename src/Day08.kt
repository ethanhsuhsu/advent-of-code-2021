fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.split(Regex("[\\s(|)]+")) }.sumOf { it.subList(10, 14).count { setOf(2, 3, 4, 7).contains(it.length) } }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(Regex("[\\s(|)]+")) }.sumOf { t -> t.subList(0, 10).toMutableList().let { s ->
            listOf("", s.find { it.length == 2 }, "", "", s.find { it.length == 4 }, "", "", s.find { it.length == 3 }, s.find { it.length == 7 }, "")
                .map { s.remove(it); it!! }.toMutableList().also { c -> listOf(listOf(3, 5, 1, 2), listOf(5, 5, 4, 1), listOf(2, 5, 4, 0),
                    listOf(9, 6, 4, 1), listOf(6, 6, 5, 1), listOf(0, 6, 5, 0)).forEach { i -> c[i[0]] = s.find { d -> d.length == i[1] &&
                        "abcdefg".filter { !d.contains(it) && !c[i[2]].contains(it) }.length == i[3] }!!.also { s.remove(it) } } } }.let { c ->
            t.subList(10, 14).map { d -> c.indexOfFirst { it.all { d.contains(it) } && it.length == d.length } }.joinToString("").toInt() } }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 26)
    check(part2(testInput) == 61229)

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
