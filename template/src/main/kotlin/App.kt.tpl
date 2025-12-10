package com.nle.aoc.day%AOC_DAY%

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day%AOC_DAY%Solution() : Solution<List<String>, Long> {
    init {
        println("Initialized Day %AOC_DAY% solution")
    }
  
    override fun part1(input: List<String>): Long {
        return input.size.toLong()
    }

    override fun part2(input: List<String>): Long {
        return input.size.toLong()
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/example-input.txt", ",")
    var solution = Day%AOC_DAY%Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
