package com.nle.aoc.day2

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day2Solution() : Solution<List<String>, Long> {
    init {
        println("Initialized Day 2 solution")
    }
  
    fun extractStartAndEnd(input: String): Pair<Long, Long> {
        if(input.isEmpty()) return Pair(0L, 0L);
        var (start, end) = input.split("-")
        var startLong = start.trim().toLong()
        var endLong = end.trim().toLong()
        return Pair(startLong, endLong)
    }
    
    fun hasRepeatingSubstring(value: String): Boolean {
        if(value.length % 2 != 0) return false;
        var firstHalf = value.substring(0, value.length / 2)
        var secondHalf = value.substring(value.length / 2)
        return firstHalf == secondHalf;
    }
    
    // Returns true if value is made ONLY of some substring repeated >= 2 times
    fun isRepeatedPattern(value: String): Boolean {
        if (value.isEmpty()) return false
        val doubled = value + value
        val idx = doubled.indexOf(value, 1)
        return idx != -1 && idx < value.length
    }
    
    override fun part1(input: List<String>): Long {
        var ans = 0L;
        for (raw in input) {
            val token = raw.trim()
            if (token.isEmpty()) continue
            val (start, end) = extractStartAndEnd(token)
            for(i in start..end) {
                if(hasRepeatingSubstring(i.toString())) {
                    ans += i
                }
            }
        }
        return ans;
    }

    override fun part2(input: List<String>): Long {
        var ans = 0L
        for (raw in input) {
            val token = raw.trim()
            if (token.isEmpty()) continue
            val (start, end) = extractStartAndEnd(token)
            for (i in start..end) {
                if (isRepeatedPattern(i.toString())) {
                    ans += i
                }
            }
        }
        return ans
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/input.txt", ",")
    var solution = Day2Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
