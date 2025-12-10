package com.nle.aoc.day1

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day1Solution(val dialSize: Int = 100, val startPos: Int = 50) : Solution<List<String>, Int> {
    init {
        println("Initialized Day 1 solution")
    }
   
    fun extractDirectionAndChange(input: String): Pair<Char, Int>
        = Pair(input[0], input.substring(1).toInt())
    
    override fun part1(input: List<String>): Int {
        var ans = 0
        var pos = startPos
        input.forEach {
            var (direction, change) = extractDirectionAndChange(it)
            if (direction == 'L') change *= -1
            val newPos = pos + change
            println("pos: $pos, direction: $direction, change: $change, newPos: $newPos")
            pos = ((newPos % dialSize) + dialSize) % dialSize
            if(pos == 0) ans += 1
         }
        return ans
    }

    override fun part2(input: List<String>): Int{
        var ans = 0
        var pos = startPos

        input.forEach {
            var (direction, change) = extractDirectionAndChange(it)
            ans += Math.floorDiv(change, dialSize)
            change %= dialSize
            if(direction == 'L') {
                change *= -1
            }

            if((pos + change) >= dialSize || (pos > 0 && pos + change <= 0)) {
                ans += 1
            }
            pos = (pos + change + dialSize) % dialSize
            if(pos < 0) pos += dialSize
        }

        return ans
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/input.txt")
    var solution = Day1Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
