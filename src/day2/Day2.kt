package day2

import java.io.File
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    println("part1() = ${part1()}")
}

fun part1(): Int {
    val sc = Scanner(File("resource/day2"))
    var twice = 0
    var thrice = 0

    while (sc.hasNext()) {
        val word = sc.nextLine()
        val map = HashMap<Char, Int>()

        for (char in word) {
            map.putIfAbsent(char, 0)
            map[char] = map.getValue(char) + 1

        }
        if (map.contains {i -> i == 2}) {
            twice ++
        }
        if (map.contains {i -> i == 3}) {
            thrice ++
        }
    }
    return twice * thrice
}


fun HashMap<Char, Int>.contains(function: (Int) -> Boolean) : Boolean {
    for ( thing in this ) {
        if (function(thing.value)) {
            return true
        }
    }
    return false
}
