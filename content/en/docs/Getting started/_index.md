---
title: Getting Started
description: Quickly get started with Koala Plot
weight: 10
---

1. Use the [Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/) to create a new project.
2. Include Koala Plot core as a dependency in your project:
```implementation(io.github.koalaplot:koalaplot-core:<version>)```

### First Plot

The below plots the function \\( y=x^2 \\) with x from 1 to 10:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Line1.kt" 16 32 %}}
![Line1](/docs/xygraphs/line_plots/line1.png)
{{% /example %}}


You can also refer to the [samples project](https://github.com/KoalaPlot/koalaplot-samples) for more examples.
