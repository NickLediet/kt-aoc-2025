package com.nle.aoc.day1

import com.nle.aoc.utils.readResourceAsLines
import kotlin.test.Test
import kotlin.test.assertEquals

internal class AppTest {
    @Test
    fun testPart1WithExampleInputShouldReturn3AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt")
        val solution = Day1Solution()
        input?.let {
            assertEquals(3, solution.part1(it))
        } ?: throw Exception("No input found")
    }

    @Test
    fun testPart1WithInputShouldReturn1074AsTheAnswer() {
        val input = readResourceAsLines("/input.txt")
        val solution = Day1Solution()
        input?.let {
            assertEquals(1074, solution.part1(it))
        } ?: throw Exception("No input found")
    }
    @Test
    fun testPart2WithExampleInputShouldReturn6AsTheAnswer() {
        val input = readResourceAsLines("/example-input.txt")
        val solution = Day1Solution()
        input?.let {
            assertEquals(6, solution.part2(it))
        } ?: throw Exception("No input found")
    }

    @Test
    fun testPart2WithExampleInputShouldReturn6254AsTheAnswer() {
        val input = readResourceAsLines("/input.txt")
        val solution = Day1Solution()
        input?.let {
            assertEquals(6254, solution.part2(it))
        } ?: throw Exception("No input found")
    }
}