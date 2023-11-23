package io.github.koalaplot.example

import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.LinearAxisModel
import io.github.koalaplot.core.xygraph.XYGraph

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    KoalaPlotTheme(
        axis = KoalaPlotTheme.axis.copy(
            minorGridlineStyle = KoalaPlotTheme.axis.minorGridlineStyle!!.copy(
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(3f, 3f))
            )
        )
    ) {
        XYGraph(
            xAxisModel = LinearAxisModel(0f..10f),
            yAxisModel = LinearAxisModel(0f..20f),
            xAxisTitle = "X Axis Title",
            yAxisTitle = "Y Axis Title",
        ) {
        }
    }
}
