pluginManagement {
    // Defines where Gradle should look for plugins (like com.android.application)
    repositories {
        google {
            content {
                // Ensure only Android-related and Google-related plugins are resolved here
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
    // Forces modules to use only the defined repositories (good security practice)
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    // Defines where Gradle should look for libraries (like Retrofit or AppCompat)
    repositories {
        google()
        mavenCentral()
    }
}

// Defines the root name of the project
rootProject.name = "HelloAndroid"
// Includes the main application module
include(":app")