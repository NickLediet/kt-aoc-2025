# kt-aoc-2025

This project uses [Gradle](https://gradle.org/).
To build and run the application, use the *Gradle* tool window by clicking the Gradle icon in the right-hand toolbar,
or run it directly from the terminal:

* Run `./gradlew run` to build and run the application.
* Run `./gradlew build` to only build the application.
* Run `./gradlew check` to run all checks, including tests.
* Run `./gradlew clean` to clean all build outputs.

Note the usage of the Gradle Wrapper (`./gradlew`).
This is the suggested way to use Gradle in production projects.

[Learn more about the Gradle Wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html).

[Learn more about Gradle tasks](https://docs.gradle.org/current/userguide/command_line_interface.html#common_tasks).

This project follows the suggested multi-module setup and consists of the `app` and `utils` subprojects.
The shared build logic was extracted to a convention plugin located in `buildSrc`.

This project uses a version catalog (see `gradle/libs.versions.toml`) to declare and version dependencies
and both a build cache and a configuration cache (see `gradle.properties`).

### Generate a new Advent of Code day

Use the project generation script to scaffold a new day module from the template:

```bash
./scripts/init-aoc-project.sh <day-number>
# example:
./scripts/init-aoc-project.sh 4
```

- **What it does**:
  - Copies `template/` to `day<day-number>/`
  - Replaces `%AOC_DAY%` placeholders in `App.kt`, `AppTest.kt`, and `build.gradle.kts`
  - Removes the `.tpl` files
  - Adds `include(":day<day-number>")` to `settings.gradle.kts` if missing
- **After generating**:
  - Update inputs in `day<day-number>/src/main/resources/` (`example-input.txt`, `input.txt`)
  - Run the new module:
    - `./gradlew :day<day-number>:run`
    - `./gradlew :day<day-number>:test`

Note: The script is written for macOS/BSD `sed`. It should work as-is on macOS (Darwin).