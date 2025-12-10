package com.nle.aoc.day1

import com.nle.aoc.utils.Solution

fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

class Day1Solution() : Solution<List<String>, Int> {
    override fun part1(input: List<String>): Int {
       return  5
    }

    override fun part2(input: List<String>): Int{
        return 5
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var fileContents = getResourceAsText("/example-input.txt")
//    fileContents ? println(fileContents) : println("No file found")
    fileContents?.let {
        println(it)
    } ?: println("No file found")

    // Read lines into a list

}
