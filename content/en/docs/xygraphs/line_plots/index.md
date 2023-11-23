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

A scatter plot is very similar to a line plot, and uses the same ```LinePlot``` Composable function, except instead of lines connecting data points a symbol is drawn at each data point. In Koala Plot, the symbols are themselves Composables, and to make it even simpler provides the {{< api pkg="" sym="Symbol()" >}}Symbol{{< /api >}} Composable to make it easy to use a Shape with any fill and outline. Beyond the standard Compose circle and rectangle shapes, Koala Plot also defines additional shapes that are common for graphs, such as the {{< api pkg="" sym="TriangleShape()" >}}TriangleShape{{< /api >}} and {{< api pkg="" sym="DiamondShape()" >}}DiamondShape{{< /api >}}.

The below example illustrates a scatter plot using the default ```RectangleShape``` used by ```Symbol```.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Scatter1.kt" 16 34 %}}
![Scatter plot](Scatter1.png)
{{% /example %}}

## Combining Lines & Symbols

Combining lines and symbols on a single ```XYGraph``` is as simple as repeatedly using ```LinePlot``` for each data series to be plotted. The below example illustrates the scatter plot from the previous example, together with a plot of a line.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Scatter2.kt" 17 40 %}}
![Scatter plot](Scatter2.png)
{{% /example %}}

The z-order of the plots corresponds to the order in which they appear in the ```XYGraph```, so in this example the line is plotted first, and the rectangle symbols are plotted second and draw over the line.

It is also possible to plot both lines and symbols with the same ```LinePlot```, as illustrated below, which is a modification of the previous example plotting the function \\( y=x^2 \\).

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/Line3.kt" 29 33 %}}
![Line with symbols](Line3.png)
{{% /example %}}