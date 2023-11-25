@file:Suppress("MagicNumber")

package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.AreaBaseline
import io.github.koalaplot.core.line.AreaPlot
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toString
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel
import kotlin.math.pow

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val data1 = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), 10f * (1.04).pow(i).toFloat()))
        }
    }
    val data2 = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), 10f * (1.06).pow(i).toFloat()))
        }
    }

    XYGraph(
        rememberLinearAxisModel(0f..12f),
        rememberLinearAxisModel(0f..20f),
        xAxisTitle = "",
        yAxisTitle = "",
        xAxisLabels = { it.toString(1) },
        yAxisLabels = { it.toString(1) }
    ) {
        LinePlot(
            data = data1,
            lineStyle = LineStyle(brush = SolidColor(Color(0xFF00498F)), strokeWidth = 2.dp),
        )
        AreaPlot(
            data = data2,
            lineStyle = LineStyle(brush = SolidColor(Color(0xFF37A78F)), strokeWidth = 2.dp),
            areaStyle = AreaStyle(
                brush = SolidColor(Color(0xFF37A78F)),
                alpha = 0.5f,
            ),
            areaBaseline = AreaBaseline.ArbitraryLine(data1)
        )
    }
}
