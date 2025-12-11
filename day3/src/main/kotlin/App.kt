package com.nle.aoc.day3

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day3Solution(val MAX_VALUE: Char = '9') : Solution<List<String>, Long> {
    override fun part1(input: List<String>): Long {
        var ans = 0L
        input.forEach {
            var leftValueIndex = 0;
            for(i in 0..it.length - 2) { // Offset by 1 as a second char is needed to correctly build the string.  If the max value is found second from last it's still valid
                // println("Processing char at index $i: ${it[i]}")
                // Case to handle 9s
                if(it[i] == MAX_VALUE) {
                    leftValueIndex = i;
                    break
                }

                // Case where value is less than 9, but greater than the current largest value
                if(it[i].code > it[leftValueIndex].code) {
                    leftValueIndex = i;
                }
            }

            var leftChar = it[leftValueIndex]
            var rightValueIndex = 0;
            var substring = it.substring(leftValueIndex + 1)
            for(i in 0..substring.length - 1) {
                if(substring[i] == MAX_VALUE) {
                    rightValueIndex = i;
                    break
                }
                if(substring[i].code > substring[rightValueIndex].code) {
                    rightValueIndex = i;
                }
            }

            var rightChar = substring[rightValueIndex]
            ans += (leftChar.toString() + rightChar.toString()).toLong()
        }
        return ans
    }

    // Use maxIterations so we're always searching in a valid length substring
    fun buildString(input: String, maxIterations: Int): String { // Note: If stackoverflows, we need to memoize the results
		if (maxIterations == 0 || input.isEmpty()) {
			return ""
		}
        var largestValueIndex = 0;
		for(i in 0..input.length - maxIterations) { // Search up to inclusive boundary to leave enough chars for the remainder
            // Case to handle 9s
            if(input[i] == MAX_VALUE) {
                largestValueIndex = i;
                break
            }

            // Case where value is less than 9, but greater than the current largest value
            if(input[i].code > input[largestValueIndex].code) {
                largestValueIndex = i;
            }
        }
        return input[largestValueIndex].toString() + buildString(input.substring(largestValueIndex + 1), maxIterations - 1)
    }

    override fun part2(input: List<String>): Long {
        var ans = 0L
        input.forEach {
            ans += buildString(it, 12).toLong()
        }
        return ans
    }
}

fun main() {
    var fileContents = readResourceAsLines("/input.txt")
    var solution = Day3Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")
}
