---
title: Getting Started
description: Quickly get started with Koala Plot
weight: 10
---

### Repositories

Add the mavenCentral and compose repositories to your project's build.gradle.kts

{{% code "/examples/build.gradle.kts" 7 11 %}}

Including ```mavenLocal()``` is optional, if you want to use pre-release builds you create locally.

### Dependencies

Include Koala Plot core as a dependency in your project's build.gradle.kts

{{% code "/examples/build.gradle.kts" 29 29 %}}

You can also see a complete example of a build.gradle.kts in the [samples](https://github.com/KoalaPlot/koalaplot-samples/blob/main/build.gradle.kts).


### First Plot

The below plots the function \\( y=x^2 \\) with x from 1 to 10:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Line1.kt" 17 31 %}}
![Line1](/docs/xygraphs/line_plots/line1.png)
{{% /example %}}
