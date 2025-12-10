package com.nle.aoc.utils

import kotlin.time.Instant
import kotlin.time.Clock
import kotlinx.serialization.Serializable
import kotlinx.coroutines.*
import kotlin.time.ExperimentalTime

@Serializable
class Printer(val message: String) {
    @OptIn(ExperimentalTime::class)
    fun printMessage() = runBlocking {
        val now: Instant = Clock.System.now()
        launch {
            delay(1000L)
            println(now.toString())
        }
        println(message)
    }
}

interface Solution<IT, T>  {
    fun part1(input: IT): T
    fun part2(input: IT): T
}

fun getResourceAsText(path: String): String? =
    object {}.javaClass.getResource(path)?.readText()

fun readResourceAsLines(path: String, separator: String = "\n"): List<String>? =
    getResourceAsText(path)?.let { it.split(separator) }