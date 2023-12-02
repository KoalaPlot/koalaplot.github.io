---
title: Bullet Graphs
description: 
weight: 40
---

The bullet graph is a type of linear bar guage and is based on the [Perceptual Edge Bullet Graph Design Specification](http://www.perceptualedge.com/articles/misc/Bullet_Graph_Design_Spec.pdf).

The below example creates a single bullet graph with a two-line title.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/BulletGraph.kt" 20 41 %}}
![Bullet](bullet.png)
{{% /example %}}

It is common to use multiple bullet graphs together, and to ensure each is the same width and with labels aligned. That is possible using the {{< api pkg="bar" sym="BulletGraphs()" >}}BulletGraphs{{< /api >}} Composable as demonstrated below.

{{% example "/examples/src/jvmMain/kotlin/io/github/koalaplot/example/BulletGraph2.kt" 20 53 %}}
![Bullet](BulletGraph2.png)
{{% /example %}}
