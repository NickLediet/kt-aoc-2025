package com.nle.aoc.day3

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day3Solution(val MAX_VALUE: Char = '9') : Solution<List<String>, Long> {
    init {
        println("Initialized Day 3 solution")
    }
  
    override fun part1(input: List<String>): Long {
        var ans = 0L
        input.forEach {
            var leftValueIndex = 0;
            println("Processing line $it")
            for(i in 0..it.length - 2) { // Offset by 1 as a second char is needed to correctly build the string.  If the max value is found second from last it's still valid
                // println("Processing char at index $i: ${it[i]}")
                // Case to handle 9s
                if(it[i] == MAX_VALUE) {
                    println("Found 9 at index $i of line $it")
                    leftValueIndex = i;
                    break
                }

                // Case where value is less than 9, but greater than the current largest value
                if(it[i].code > it[leftValueIndex].code) {
                    leftValueIndex = i;
                }
            }

            var leftChar = it[leftValueIndex]
            println("Left char: $leftChar (index of $leftValueIndex)")
            var rightValueIndex = 0;
            var substring = it.substring(leftValueIndex + 1)
            println("Processing substring: $substring")
            println("substring has length of ${substring.length}" )
            for(i in 0..substring.length - 1) {
                println("i = $i, substring[i] = ${substring[i]}")
                if(substring[i] == MAX_VALUE) {
                    println("Found 9 at index $i of line $it")
                    rightValueIndex = i;
                    break
                }
                if(substring[i].code > substring[rightValueIndex].code) {
                    println("Found new right value at index $i of line $it. (${substring[i]} > ${substring[rightValueIndex]})")
                    rightValueIndex = i;
                }
            }

            var rightChar = substring[rightValueIndex]
            println("Left char: $leftChar, Right char: $rightChar")
            ans += (leftChar.toString() + rightChar.toString()).toLong()
            println("Current ans: $ans")
        }
        return ans
    }

    // Use maxIterations so we're always searching in a valid length substring
    fun buildString(input: String, maxIterations: Int): String { // Note: If stackoverflows, we need to memoize the results
        var largestValueIndex = 0;
        println("Processing line $input")
        for(i in 0..input.length - maxIterations - 1) { // Offset by 1 as a second char is needed to correctly build the string.  If the max value is found second from last it's still valid
            // Case to handle 9s
            if(input[i] == MAX_VALUE) {
                println("Found 9 at index $i of line $input")
                largestValueIndex = i;
                break
            }

            // Case where value is less than 9, but greater than the current largest value
            if(input[i].code > input[largestValueIndex].code) {
                println("Found new largest value at index $i of line $input. (${input[i]} > ${input[largestValueIndex]})")
                largestValueIndex = i;
            }
        }
        println("Largest value index: $largestValueIndex with a value of ${input[largestValueIndex]}")
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

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/example-input.txt")
    var solution = Day3Solution()
    fileContents?.let {
        // println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
