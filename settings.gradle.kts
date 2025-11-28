pluginManagement {
<<<<<<< HEAD
    // Defines where Gradle should look for plugins (like com.android.application)
    repositories {
        google {
            content {
                // Ensure only Android-related and Google-related plugins are resolved here
=======
    repositories {
        google {
            content {
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
<<<<<<< HEAD
    // Forces modules to use only the defined repositories (good security practice)
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // Defines where Gradle should look for libraries (like Retrofit or AppCompat)
=======
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
// Defines the root name of the project
rootProject.name = "HelloAndroid"
// Includes the main application module
include(":app")
=======
rootProject.name = "HelloAndroid"
include(":app")
 
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
