#!/usr/bin/env bash

# This script initializes a new AOC project.
# It creates a new directory for the project and copies the template files into it.
# It then opens the project in IntelliJ IDEA.

# Usage: ./init-aoc-project.sh <day>
# Example: ./init-aoc-project.sh 1

# Check if the day is provided
if [ -z "$1" ]; then
    echo "Error: Day is required"
    exit 1

fi

# Create the project directory
DAY=$1
cp -r template/ "day$DAY"

# Replace the day in the template files
sed -i "s/%AOC_DAY%/$DAY/g" "day$DAY/src/main/kotlin/App.kt"
sed -i "s/%AOC_DAY%/$DAY/g" "day$DAY/src/test/kotlin/AppTest.kt"
sed -i "s/%AOC_DAY%/$DAY/g" "day$DAY/build.gradle.kts"

# Update the settings.gradle.kts file to include the new project by adding a new line before the last line and adding the new project to the list of projects
sed -i "s/}/}\n\ninclude(\":day$DAY\")/" "settings.gradle.kts"
