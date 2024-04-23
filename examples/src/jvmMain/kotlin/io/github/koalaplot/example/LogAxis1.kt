package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.LogAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.autoScaleXRange
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val data = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), i * i.toFloat()))
        }
    }

    XYGraph(
        xAxisModel = rememberFloatLinearAxisModel(data.autoScaleXRange()),
        yAxisModel = LogAxisModel(-1..2)
    ) {
        LinePlot(
            data,
            lineStyle = LineStyle(SolidColor(Color.Blue))
        )
    }
}
