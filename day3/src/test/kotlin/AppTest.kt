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

    @Test
    fun testPart2WithExampleInputShouldReturn3121910778619AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt")
        val solution = Day3Solution()
        input?.let {
            assertEquals(3121910778619L, solution.part2(it))
        } ?: throw Exception("No input found")
    }

    @Test
    fun testPart2WithRealInputShouldReturn173685428989126AsTheAnswer() {
        val input = readResourceAsLines("/input.txt")
        val solution = Day3Solution()
        input?.let {
            assertEquals(173685428989126L, solution.part2(it))
        } ?: throw Exception("No input found")
    }
}