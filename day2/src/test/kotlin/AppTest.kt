package com.nle.aoc.day2

import com.nle.aoc.utils.readResourceAsLines
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AppTest {
    @Test
    fun testHasRepeatingSubstringWithExampleInputShouldReturnFalse() {
        val input = "1227775554"
        val solution = Day2Solution()
        assertEquals(false, solution.hasRepeatingSubstring(input))
    }
    @Test
    fun testHasRepeatingSubstringWithExampleInputShouldReturnTrue() {
        val input = "123123"
        val solution = Day2Solution()
        assertEquals(true, solution.hasRepeatingSubstring(input))
    }

    @Test
    fun testPart1WithExampleInputShouldReturn1227775554AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt", ",")
        val solution = Day2Solution()
        input?.let {
            assertEquals(1227775554, solution.part1(it))
        } ?: throw Exception("No input found")
    }
}