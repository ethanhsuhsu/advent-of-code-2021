fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { l -> ArrayDeque<Char>().let { s -> l.forEach { if("([{<".contains(it)) s.addFirst(it) else if(s.first() == it -
            if(s.first() == '(') 1 else 2) s.removeFirst() else return@sumOf mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)[it]!! } }; 0 } }

    fun part2(input: List<String>): Long {
        return input.map { l -> ArrayDeque<Char>().also { s -> l.forEach { if("([{<".contains(it)) s.addFirst(it) else if(s.first() == it - if(s.first() == '(') 1 else 2)
            s.removeFirst() else return@map 0 } }.fold(0L) { a, c -> (5*a) + listOf('(','[','{','<').indexOf(c) + 1 } }.filter { it != 0L }.sorted().let{ it[(it.size) / 2]}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 26397)
    check(part2(testInput) == 288957L)

    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}
