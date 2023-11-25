@file:Suppress("MagicNumber")

package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.AreaBaseline
import io.github.koalaplot.core.line.StackedAreaPlot
import io.github.koalaplot.core.line.StackedAreaPlotDataAdapter
import io.github.koalaplot.core.line.StackedAreaStyle
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toString
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel
import kotlin.random.Random

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val random = Random(10)

    fun makeRandomLine(): List<Float> = buildList {
        var last = 0f
        for (i in 1..10) {
            last += random.nextFloat()
            add(last)
        }
    }

    val randomLines = List(4) { makeRandomLine() }
    val stackData = StackedAreaPlotDataAdapter(randomLines[0].indices.toList().map { (it + 1).toFloat() }, randomLines)
    val styles = List(4) {
        StackedAreaStyle(
            LineStyle(SolidColor(Color.Black), strokeWidth = 2.dp),
            AreaStyle(SolidColor(Color.Blue.copy(alpha = 0.20f * (it + 1))))
        )
    }

    XYGraph(
        rememberLinearAxisModel(0f..12f),
        rememberLinearAxisModel(0f..25f),
        xAxisTitle = "",
        yAxisTitle = "",
        xAxisLabels = { it.toString(1) },
        yAxisLabels = { it.toString(1) }
    ) {
        StackedAreaPlot(
            stackData,
            styles,
            AreaBaseline.ConstantLine(0f)
        )
    }
}
