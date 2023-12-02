---
title: Theming
description: Customize a theme for default plot characteristics
weight: 60
---

Use {{< api pkg="style" sym="KoalaPlotTheme()" >}}KoalaPlotTheme{{< /api >}} to customize default settings used for Koala Plot visual elements. Use it just like MaterialTheme: wrap your content in a  call to the Composable ```KoalaPlotTheme```, setting any function arguments desired.

The below exampleshows changing the color of the axes from light gray to black, and removing the rendering of minor ticks.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Theming1.kt" 35 57 %}}
![Theming](Theming1.png)
{{% /example %}}


