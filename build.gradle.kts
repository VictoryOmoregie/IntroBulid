// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false // <- This line likely holds the 'com.android.application' plugin alias
}
