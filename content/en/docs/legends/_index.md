---
title: Chart Layout & Legends
description: Layout charts with plots and legends
weight: 50
---

## Laying out Charts

{{< api pkg="" sym="ChartLayout()" >}}ChartLayout{{< /api >}} is a simple aid for laying out the plot, a title, and a legend. The plot is the main content, with an optional legend that can be placed above, below, to the left, or to the right of it. A title is centered above the other content. ```ChartLayout``` has few options and expects the contained Composables to use padding and borders as preferred to achieve the desired look.

The below example illustrates how the components are placed relative to each other when the legend is placed to the left of the plot.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/ChartLayout1.kt" 25 43 %}}
![Chart layout](ChartLayout1.png)
{{% /example %}}

{{% alert title="Caution" color="warning" %}}
By default charts will expand to fill all horizontal and/or vertical space available, and so if placed within a scrollable container must have a modifier applied that will limit their size.
{{% /alert %}}

## Legends

To assist with generating legends, Koala Plot provides two Composables {{< api pkg="legend" sym="ColumnLegend()" >}}ColumnLegend{{< /api >}} and {{< api pkg="legend" sym="FlowLegend()" >}}FlowLegend{{< /api >}}. The above example included an example of ```ColumnLegend```. It places a symbol, a label, and a value in rows, each aligned in columns. A ```ColumnLegend``` with all three
items in each row is included in the example below:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/ColumnLegend1.kt" 22 28 %}}
![Column Legend](ColumnLegend1.png)
{{% /example %}}

```FlowLegend``` is best used above or below the graph, and will expand to be as wide as necessary to fit its content. Once it reaches the maximum width allocated to it, it will place additional items on the next row. The below example demonstrates this wrapping feature when the available width is too small to hold all items in a single row:

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/FlowLegend1.kt" 22 27 %}}
![Flow Legend](FlowLegend1.png)
{{% /example %}}
