package io.github.koalaplot.example

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.bar.solidBar
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val categories = listOf("Initial Cash", "Q1", "Q2", "Q3", "Q4", "Final Cash")

    XYGraph(
        xAxisModel = remember { CategoryAxisModel(categories) },
        yAxisModel = rememberFloatLinearAxisModel(0f..150f, minorTickCount = 0),
    ) {
        VerticalBarPlot {
            item("Initial Cash", 0f, 100f, solidBar(Color.DarkGray))
            item("Q1", 100f, 120f, solidBar(Color(0xFF00498F)))
            item("Q2", 120f, 90f, solidBar(Color(0xFFED7D31)))
            item("Q3", 90f, 110f, solidBar(Color(0xFF00498F)))
            item("Q4", 110f, 130f, solidBar(Color(0xFF00498F)))
            item("Final Cash", 0f, 130f, solidBar(Color.DarkGray))
        }
    }
}
