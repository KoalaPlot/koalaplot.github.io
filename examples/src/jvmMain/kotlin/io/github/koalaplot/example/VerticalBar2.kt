package io.github.koalaplot.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.DefaultVerticalBar
import io.github.koalaplot.core.bar.VerticalBarPlot
import io.github.koalaplot.core.bar.verticalBarPlotEntry
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.XYGraphScope
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val categories = listOf("Initial Cash", "Q1", "Q2", "Q3", "Q4", "Final Cash")
    val colors = listOf(
        Color.DarkGray, Color(0xFF00498F), Color(0xFFED7D31),
        Color(0xFF00498F), Color(0xFF00498F), Color.DarkGray,
    )
    val data = listOf(
        verticalBarPlotEntry(categories[0], 0f, 100f),
        verticalBarPlotEntry(categories[1], 100f, 120f),
        verticalBarPlotEntry(categories[2], 120f, 90f),
        verticalBarPlotEntry(categories[3], 90f, 110f),
        verticalBarPlotEntry(categories[4], 110f, 130f),
        verticalBarPlotEntry(categories[5], 0f, 130f),
    )

    XYGraph(
        xAxisModel = remember { CategoryAxisModel(categories) },
        yAxisModel = rememberFloatLinearAxisModel(0f..150f, minorTickCount = 0),
    ) {
        VerticalBarPlot(
            data,
            bar = { DefaultVerticalBar(SolidColor(colors[it])) }
        )
    }
}

@Composable
private fun XYGraphScope<String, Float>.x() {
    VerticalBarPlot {
        item("Initial Cash", 0f, 100f) { DefaultVerticalBar(SolidColor(Color.DarkGray)) }
        item("Q1", 100f, 120f) { DefaultVerticalBar(SolidColor(Color(0xFF00498F))) }
        item("Q2", 120f, 90f) { DefaultVerticalBar(SolidColor(Color(0xFFED7D31))) }
        item("Q3", 90f, 110f) { DefaultVerticalBar(SolidColor(Color(0xFF00498F))) }
        item("Q4", 110f, 130f) { DefaultVerticalBar(SolidColor(Color(0xFF00498F))) }
        item("Final Cash", 0f, 130f) { DefaultVerticalBar(SolidColor(Color.DarkGray)) }
    }
}
