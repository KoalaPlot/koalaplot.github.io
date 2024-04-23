package io.github.koalaplot.example

import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val burroughs = listOf("Bronx", "Brooklyn", "Manhattan", "Queens", "Staten Island")

    XYGraph(
        xAxisModel = CategoryAxisModel(burroughs),
        yAxisModel = rememberFloatLinearAxisModel(0f..4f, minorTickCount = 0),
        yAxisTitle = "Population (Millions)"
    ) {
    }
}
