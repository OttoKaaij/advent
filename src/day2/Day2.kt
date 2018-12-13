package day2

import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    println("part1() = ${part1()}")
    println("part2() = ${part2()}")

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

fun part2(): String {

    val words = ArrayList<String>()
    val sc = Scanner(File("resource/day2"))

    while (sc.hasNext()) {
        words.add(sc.nextLine())
    }

    words.forEach {
        val index = compareWords(it, words)
        if (index != -1) {
            return it.removeRange(index, index + 1)
        }
    }
    return ""
}

fun compareWords(word: String, words: ArrayList<String>) : Int {
    words.forEach {cmpWord ->
        var firstMatch = -1
        var secondMatch = -1
        word.forEachIndexed {index, c ->
            if (cmpWord[index] != c) {
                if (firstMatch != -1) {
                    secondMatch = index
                }
                firstMatch = index
            }
        }
        if (firstMatch != -1 && secondMatch == -1) {
            return firstMatch
        }
    }
    return -1
}

fun HashMap<Char, Int>.contains(function: (Int) -> Boolean) : Boolean {
    for ( thing in this ) {
        if (function(thing.value)) {
            return true
        }
    }
    return false
}
