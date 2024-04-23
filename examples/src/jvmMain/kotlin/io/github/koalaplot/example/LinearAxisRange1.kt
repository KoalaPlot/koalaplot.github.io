package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val data = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), i * i.toFloat()))
        }
    }

    XYGraph(
        rememberFloatLinearAxisModel(0f..12f, minorTickCount = 0),
        rememberFloatLinearAxisModel(-10f..110f, minorTickCount = 0),
    ) {
        LinePlot(
            data,
            lineStyle = LineStyle(SolidColor(Color.Blue))
        )
    }
}
