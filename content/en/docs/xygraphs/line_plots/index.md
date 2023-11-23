---
title: Line & Scatter Plots
description: Plotting lines and points in 2-d
weight: 10
---


## Basics

A line plot requires a list of data points, (x, y) pairs, with the data type and in the coordinate system of the axes provided to the enclosing ```XYGraph```. As an example, we want to plot the function \\( y=x^2 \\) with x from 1 to 10 with two Float axes:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Line1.kt" 17 31 %}}
![Line1](line1.png)
{{% /example %}}

Lines 1-5 generate the data to plot. The data for Line plots is a list of x, y coordinates provided by an implementation of the {{< api pkg="xychart" sym="Point" >}}Point{{< /api >}} interface. This example uses the provided implementation, {{<api pkg="xychart" sym="DefaultPoint">}}DefaultPoint{{</api>}}. 

Lines 8 and 9 provide an AxisModel for each of the x and y axes to XYChart. In this case, we are using linear axes with floating point values (other types are covered in [XY Graphs]({{% ref "/docs/xygraphs/#axes" %}})) and ranges that are calculated with the
calls to ```autoScaleXRange()``` and ```autoScaleYRange()```.

Lines 11 through 13 call the ```LineChart``` Composable to render the line itself, using a solid blue style.

### Adding a Second Line

Now lets add a second line plotting the function \\( y=e^{\sqrt{x}} \\), which looks like this:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Line2.kt" 33 49 %}}
![Line2](line2.png)
{{% /example %}}

## Scatter Plots

## Combining Lines & Symbols
