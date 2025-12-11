package com.nle.aoc.day4

import com.nle.aoc.utils.readResourceAsLines
import com.nle.aoc.day4.Day4Solution
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AppTest {
    // part 1 example input should return 13
    @Test
    fun testPart1WithExampleInputShouldReturn13AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt")
        val solution = Day4Solution()
        input?.let {
            assertEquals(13, solution.part1(it))
        } ?: throw Exception("No input found")
    }
    @Test
    fun testPart1WithRealInputShouldReturn1416AsTheAnswer() {
        val input = readResourceAsLines("/input.txt")
        val solution = Day4Solution()
        input?.let {
            assertEquals(1416, solution.part1(it))
        } ?: throw Exception("No input found")
    }
}