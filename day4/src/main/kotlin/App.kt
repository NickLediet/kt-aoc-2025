package com.nle.aoc.day4

import com.nle.aoc.utils.Solution
import com.nle.aoc.utils.readResourceAsLines
import java.lang.Math

class Day4Solution(val paperChar: Char = '@') : Solution<List<String>, Long> {
    init {
        println("Initialized Day 4 solution")
    }

    fun checkNumberOfAdjacentPaperChars(input: List<String>, rowIndex: Int, colIndex: Int): Int {
        var ans = 0
        if(rowIndex > 0 && input[rowIndex - 1][colIndex] == paperChar) ans += 1
        if(rowIndex < input.size - 1 && input[rowIndex + 1][colIndex] == paperChar) ans += 1
        if(colIndex > 0 && input[rowIndex][colIndex - 1] == paperChar) ans += 1
        if(colIndex < input[rowIndex].length - 1 && input[rowIndex][colIndex + 1] == paperChar) ans += 1
		// Diagonals
		if(rowIndex > 0 && colIndex > 0 && input[rowIndex - 1][colIndex - 1] == paperChar) ans += 1
		if(rowIndex > 0 && colIndex < input[rowIndex].length - 1 && input[rowIndex - 1][colIndex + 1] == paperChar) ans += 1
		if(rowIndex < input.size - 1 && colIndex > 0 && input[rowIndex + 1][colIndex - 1] == paperChar) ans += 1
		if(rowIndex < input.size - 1 && colIndex < input[rowIndex].length - 1 && input[rowIndex + 1][colIndex + 1] == paperChar) ans += 1
        return ans
    }
    override fun part1(input: List<String>): Long {
        var ans = 0L
        for((rowIndex, row) in input.withIndex()) {
            for((colIndex, col) in row.withIndex()) {
                if(col != paperChar) continue
				if(checkNumberOfAdjacentPaperChars(input, rowIndex, colIndex) < 4) ans += 1
            }
        }
        return ans
    }

	private fun checkNumberOfAdjacentPaperChars(grid: Array<CharArray>, rowIndex: Int, colIndex: Int): Int {
		var ans = 0
		if(rowIndex > 0 && grid[rowIndex - 1][colIndex] == paperChar) ans += 1
		if(rowIndex < grid.size - 1 && grid[rowIndex + 1][colIndex] == paperChar) ans += 1
		if(colIndex > 0 && grid[rowIndex][colIndex - 1] == paperChar) ans += 1
		if(colIndex < grid[rowIndex].size - 1 && grid[rowIndex][colIndex + 1] == paperChar) ans += 1
		// Diagonals
		if(rowIndex > 0 && colIndex > 0 && grid[rowIndex - 1][colIndex - 1] == paperChar) ans += 1
		if(rowIndex > 0 && colIndex < grid[rowIndex].size - 1 && grid[rowIndex - 1][colIndex + 1] == paperChar) ans += 1
		if(rowIndex < grid.size - 1 && colIndex > 0 && grid[rowIndex + 1][colIndex - 1] == paperChar) ans += 1
		if(rowIndex < grid.size - 1 && colIndex < grid[rowIndex].size - 1 && grid[rowIndex + 1][colIndex + 1] == paperChar) ans += 1
		return ans
	}

    override fun part2(input: List<String>): Long {
		var ans = 0L
		val grid = input.map { it.toCharArray() }.toTypedArray()
		var removedInPass: Int
		do {
			removedInPass = 0
			for((rowIndex, row) in grid.withIndex()) {
				for(colIndex in row.indices) {
					if(grid[rowIndex][colIndex] != paperChar) continue
					if(checkNumberOfAdjacentPaperChars(grid, rowIndex, colIndex) < 4) {
						ans += 1
						grid[rowIndex][colIndex] = 'x'
						removedInPass += 1
					}
				}
			}
		} while (removedInPass > 0)
		return ans
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = readResourceAsLines("/input.txt")
    var solution = Day4Solution()
    fileContents?.let {
        println("Part 1: ${solution.part1(fileContents)}")
        println("Part 2: ${solution.part2(fileContents)}")
    } ?: println("No file found")

    // Read lines into a list
}
