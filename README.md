# PaperPluginTemplate-Kotlin

This is a template for a Kotlin Plugin for the Paper Server
Software. It comes along with the depdencies and configurations
I use when programming plugins with Kotlin, such as ShadowJar,
for creating a fat jar and Spotless, for code formatting.

## How to use

Please follow these steps to fully prepare this template for your
own use:
- In the top right corner of this page, click the green
"Use this template" button. From there, you can follow the
instructions to create a new repository with this template.
- Clone your new repository to your local machine and open it
with your preferred IDE. For the sake of simplicity, this tutorial
will assume you are using IntelliJ IDEA.
- Open the `build.gradle.kts` file and change the `group` field
to your own group id. At this stage, if you wish, you may also
change the `version` field to your own version number.
- Open the `src` folder and navigate to `main`, `kotlin` and
highlight the `joshdev.paperPluginTemplateKotlin` package. Right
click on it and select `Refactor` -> `Rename` and rename the
package to your own package name.
- Open the `plugin.yml` file within the `resources` directory
and change the `name` and `main` fields to your own plugin name
and main class name, respectively.
- Open the `settings.gradle.kts` file and change the
`rootProject.name` field to your own plugin name.
- Open the `README.md` file and customise as required.
- You are now ready to start coding your plugin!