package day1

import java.io.File
import java.util.*
import kotlin.collections.HashSet


fun main(args: Array<String>) {
    println(part1())
    println(part2())
}

fun part1() : Int {
    val sc = Scanner(File("resource/day1"))
    var res = 0;
    var current = ""
    while (sc.hasNext()) {
        current = sc.nextLine()
        if (current[0] == '+') {
            res += current.substring(1).toInt()
        } else {
            res -= current.substring(1).toInt()
        }
    }
    return res
}

fun part2() : Int {
    var currFreq = 0
    val freqs = HashSet<Int>()

    while (true) {
        val sc = Scanner(File("resource/day1"))

        while (sc.hasNext()) {
            currFreq = updateFrequency(sc, currFreq)
            if (freqs.contains(currFreq)) {
                return currFreq
            }
            freqs.add(currFreq)
        }


    }
}

fun updateFrequency(scanner: Scanner, freq: Int) : Int {
    val current = scanner.nextLine()
    var res = freq
    if (current[0] == '+') {
        res += current.substring(1).toInt()
    } else {
        res -= current.substring(1).toInt()
    }
    return res

}

