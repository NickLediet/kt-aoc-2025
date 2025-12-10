package com.nle.aoc.day3

import com.nle.aoc.utils.readResourceAsLines
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AppTest {
    @Test
    fun testPart1WithExampleInputShouldReturn357AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt")
        val solution = Day3Solution()
        input?.let {
            assertEquals(357, solution.part1(it))
        } ?: throw Exception("No input found")
    }

    @Test
    fun testPart1WithRealInputShouldReturn17493AsTheAnswer() {
        val input = readResourceAsLines("/input.txt")
        val solution = Day3Solution()
        input?.let {
            assertEquals(17493, solution.part1(it))
        } ?: throw Exception("No input found")
    }
}