# Build framework

## Overview of the task

Contributor(s), reviewer(s) and progress were tracked in this issue:
[#6](https://github.com/BME-MIT-IET/iet-hf2021-v-dqw4w9wgxcq/issues/6)

### Original description (in Hungarian)
Build keretrendszer beüzemelése, ha még nincs (Maven, Gradle...) + CI beüzemelése, ha még nincs (Actions, Travis, AppVeyor, Azure Pipelines...)

### Actionable subtasks
- Investigating how gradle works and how to build a Java library with it
- Understanding how gradle subprojects work
- Generating a gradle project
- Migrating the elements of the project

## Work done
First we checked the `.gitignore` to know wich ignores are needed and wich are not. After this the project compiled successfully and the tests ran. _(The test could be simply copied.)_ Then we had to refactor the `.gitignore` file based on the build outputs.

The next step was to get a CLI tool and create a subproject for it. Made the CLI be able to use the libraries by setting up the dependencies in gradle.

To ensure that the CLI can be used on other desktops we made a fatJar with a gradle plugin. _(The fatJar contains all the project dependencies not only the code.)_

## Results
We have a nicely working build framework tool.

## Lessons learned
We got to know how to create a CLI subproject in gradle and how to deal with dependencies.
