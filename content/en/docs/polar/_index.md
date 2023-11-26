---
title: Polar/Radar & Spider Plots
description: 
weight: 30
---

Polar, Radar, and Spider plots are different names for essentially the same thing: two-dimensional plots using a polar coodrinate system. In a 2-d polar coordinate system one axis is radial, measuring distance from the center of the graph, and the second axis is angular, measuring angle around a circle.

## Polar Graph

Analogous to the ```XYGraph``` for 2-d Cartesian plots, there is {{< api pkg="polar" sym="PolarGraph()" >}}PolarGraph{{< /api >}} for creating the surface onto which polar plots can be composed. The below example illustrates a ```PolarGraph``` with mostly default configuration:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar1.kt" 24 28 %}}
![Polar Graph](Polar1.png)
{{% /example %}}

In this example the radial axis uses ```Float``` values, and the angular axis uses {{< api pkg="util" sym="AngularValue" >}}AngularValues{{< /api >}}, a sealed type that represents angular coordinates in degrees or radians and can transform between the two scales. The {{< api pkg="polar" sym="defaultAngularValueAxisModel" >}}defaultAngularValueAxisModel{{< /api >}} produces ticks at every 45-degrees.

The angular axis can be any type that implements the {{< api pkg="polar" sym="AngularAxisModel" >}}AngularAxisModel{{< /api >}} interface. Koala Plot provides an implementation that uses a ```List``` of elements of an arbitrary type, {{< api pkg="polar" sym="CategoryAngularAxisModel" >}}CategoryAngularAxisModel{{< /api >}}, that places its elements evenly spaced around the circumfrence of the plot.

Below is an example using ```String``` as the category objects:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar4.kt" 23 26 %}}
![Polar Graph](Polar4.png)
{{% /example %}}

### Polar Graph Styling

The above examples draw the radial grid lines as concentric circles. An alternative is to draw them as straight lines between angular grid lines, as illustrated in the below example:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar2.kt" 26 31 %}}
![Spider Graph](Polar2.png)
{{% /example %}}

This cosmetic alternative is often referred to as a Spider Chart because of its resemblance to a spider web, but functionally it is identical to the polar graph from the first example.

Other key elements of the ```PolarGraph``` that can be styled include the axis lines and the background, as shown in the below example:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar3.kt" 29 38 %}}
![Polar Graph](Polar3.png)
{{% /example %}}

## Polar Plots

{{< api pkg="polar" sym="PolarPlotSeries()" >}}PolarPlotSeries{{< /api >}} is used within the ```PolarGraph``` to plot lines, symbols, areas, or any combination of the three. The below example demonstrates using symbols to create polar scatter plots of two data sets:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar5.kt" 34 52 %}}
![Polar Scatter Plot](Polar5.png)
{{% /example %}}


To plot lines and/or areas, specify the styling for each as parameters to the ```PolarPlotSeries``` as shown in the below example:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Polar6.kt" 33 51 %}}
![Cardioid Plot](Polar6.png)
{{% /example %}}

