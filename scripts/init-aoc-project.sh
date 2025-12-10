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
# macOS/BSD sed: do not use -i when redirecting; write to new files
sed "s/%AOC_DAY%/$DAY/g" "day$DAY/src/main/kotlin/App.kt.tpl" > "day$DAY/src/main/kotlin/App.kt"
sed "s/%AOC_DAY%/$DAY/g" "day$DAY/src/test/kotlin/AppTest.kt.tpl" > "day$DAY/src/test/kotlin/AppTest.kt"
sed "s/%AOC_DAY%/$DAY/g" "day$DAY/build.gradle.kts.tpl" > "day$DAY/build.gradle.kts"
# remove the .tpl files
rm "day$DAY/src/main/kotlin/App.kt.tpl"
rm "day$DAY/src/test/kotlin/AppTest.kt.tpl"
rm "day$DAY/build.gradle.kts.tpl"

# Update the settings.gradle.kts file to include the new project before rootProject.name
# Avoid duplicates if the include already exists
if ! grep -q "include(\":day$DAY\")" "settings.gradle.kts"; then
    # BSD sed requires an empty string after -i for in-place edit without backup
    sed -i '' "/^rootProject\.name/ i\\
include(\":day$DAY\")
" "settings.gradle.kts"
fi

echo "🎉 Project initialized successfully"
echo "🚨 Please remember to update the resource files in the project directory"