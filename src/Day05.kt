import kotlin.math.*

fun main() {
    fun part1(input: List<String>): Int {
        return hashMapOf<Pair<Int,Int>, Int>().also { m -> input.map { it.split(Regex("[\\s,\\->]+"))
            .map { it.toInt() }.chunked(2) }.filter { it[0][0] == it[1][0] || it[0][1] == it[1][1] }.forEach { l ->
                if(l[0][0] == l[1][0]) for(i in min(l[0][1],l[1][1])..max(l[0][1],l[1][1])) m[l[0][0] to i] = m.getOrPut(l[0][0] to i){0} + 1
                else for(i in min(l[0][0],l[1][0])..max(l[0][0],l[1][0])) m[i to l[0][1]] = m.getOrPut(i to l[0][1]){0} + 1
            } }.count { it.value >= 2 }
    }
    fun part2(input: List<String>): Int {
        return hashMapOf<Pair<Int,Int>, Int>().also { m -> input.map { it.split(Regex("[\\s,\\->]+"))
            .map { it.toInt() }.chunked(2) }.map{ if( it[1][1] < it[0][1]) listOf(it[1],it[0]) else it }.forEach { l ->
            if(l[0][0] == l[1][0]) for(i in min(l[0][1],l[1][1])..max(l[0][1],l[1][1])) m[l[0][0] to i] = m.getOrPut(l[0][0] to i){0} + 1
            else if(l[0][1] == l[1][1]) for(i in min(l[0][0],l[1][0])..max(l[0][0],l[1][0])) m[i to l[0][1]] = m.getOrPut(i to l[0][1]){0} + 1
            else if((l[1][0] - l[0][0]) * (l[1][1] - l[0][1]) > 0) for(i in 0..abs(l[1][0] - l[0][0]))  m[l[0][0] + i to l[0][1] + i] = m.getOrPut(l[0][0] + i to l[0][1] + i){0} + 1
            else for(i in 0..abs(l[1][0] - l[0][0]))  m[l[0][0] - i to l[0][1] + i] = m.getOrPut(l[0][0] - i to l[0][1] + i){0} + 1
        } }.count { it.value >= 2 }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
