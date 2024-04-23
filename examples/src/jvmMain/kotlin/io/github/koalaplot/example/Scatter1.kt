package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.Symbol
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel
import kotlin.random.Random

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val data = buildList {
        val random = Random(10)
        for (i in 1..50) {
            val x = random.nextDouble(1.0, 10.0).toFloat()
            val y = (x + (random.nextDouble() - 0.5) * 2.0).toFloat()

            add(DefaultPoint(x, y))
        }
    }

    XYGraph(
        rememberFloatLinearAxisModel(0f..12f),
        rememberFloatLinearAxisModel(0f..12f)
    ) {
        LinePlot(
            data,
            symbol = { Symbol(fillBrush = SolidColor(Color.Blue), outlineBrush = SolidColor(Color.Black)) }
        )
    }
}
