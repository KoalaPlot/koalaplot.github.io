package io.github.koalaplot.example

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.DefaultVerticalBar
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val boroughs = listOf("Bronx", "Brooklyn", "Manhattan", "Queens", "Staten Island")
    val population = listOf(1.446788f, 2.648452f, 1.638281f, 2.330295f, 0.487155f)

    XYGraph(
        xAxisModel = remember { CategoryAxisModel(boroughs) },
        yAxisModel = rememberLinearAxisModel(0f..3f, minorTickCount = 0),
        yAxisTitle = "Population (Millions)"
    ) {
        VerticalBarPlot(
            xData = boroughs,
            yData = population,
            bar = {
                DefaultVerticalBar(SolidColor(Color.Blue))
            }
        )
    }
}
