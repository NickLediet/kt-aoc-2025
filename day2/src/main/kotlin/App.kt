package com.nle.aoc.day2

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day2Solution() : Solution<List<String>, Int> {
    init {
        println("Initialized Day 2 solution")
    }
  
    fun extractStartAndEnd(input: String): Pair<Int, Int> {
        if(input.isEmpty()) return Pair(0, 0);
        var (start, end) = input.split("-")
        var startInt = start.trim().toInt()
        var endInt = end.trim().toInt()
        return Pair(startInt, endInt)
    }
    
    fun hasRepeatingSubstring(value: String): Boolean {
        if(value.length % 2 != 0) return false;
        var firstHalf = value.substring(0, value.length / 2)
        var secondHalf = value.substring(value.length / 2)
        return firstHalf == secondHalf;
    }
    
    override fun part1(input: List<String>): Int {
        var ans = 0;
        input.forEach {
            if(it.isEmpty()) return 0;
            var (start, end) = extractStartAndEnd(it)
            for(i in start..end) {
                if(hasRepeatingSubstring(i.toString())) {
                    ans += i
                }
            }
        }
        return ans;
    }

    override fun part2(input: List<String>): Int {
        return 0
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/example-input.txt", ",")
    var solution = Day2Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents) == 1227775554}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
