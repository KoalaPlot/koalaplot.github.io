plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("io.gitlab.arturbosch.detekt")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    mavenLocal()
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:_")
}

group = "io.github.koalaplot.examples"
version = "0.5.1"

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.ui)
                implementation("io.github.koalaplot:koalaplot-core:0.5.1")
            }
        }

        named("jvmMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
    }
}
