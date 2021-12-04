fun main() {
    fun part1(input: List<String>): Int {
        return input.drop(2).joinToString(" ").trim().split(Regex("\\s+")).map { it.toInt() to false }
            .chunked(5) { it.toMutableList() }.toMutableList().chunked(5) { it.toMutableList() }.let { g ->
                input[0].split(',').map { it.toInt() }.forEach { i -> g.forEach { b -> b.forEach { r ->
                    r.indexOfFirst { it.first == i }.let { s -> if(s != -1) { r[s] = i to true
                        if((r.all { it.second } || (0..4).all { b[it][s].second }) )
                            return@part1 b.flatten().filter { !it.second }.sumOf { it.first } * i } } } } } }.let { -1 }
    }

    fun part2(input: List<String>): Int {
        return mutableSetOf<Int>().let { c -> input.drop(2).joinToString(" ").trim().split(Regex("\\s+")).map { it.toInt() to false }
            .chunked(5) { it.toMutableList() }.toMutableList().chunked(5) { it.toMutableList() }.toMutableList().let { g ->
                input[0].split(',').map { it.toInt() }.forEach { i -> g.forEachIndexed { bI, b -> b.forEach { r ->
                    r.indexOfFirst { it.first == i }.let { s -> if(s != -1) { r[s] = i to true
                        if(r.all { it.second } || (0..4).all { b[it][s].second }) { if(c.size == g.size - 1 && !c.contains(bI))
                            return@part2 b.flatten().filter { !it.second }.sumOf { it.first } * i else c += bI }} } } } } } }.let { -1 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
