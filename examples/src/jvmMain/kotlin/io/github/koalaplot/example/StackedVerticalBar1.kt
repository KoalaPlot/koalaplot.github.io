package io.github.koalaplot.example

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.StackedVerticalBarPlot
import io.github.koalaplot.core.bar.solidBar
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val boroughs = listOf("Bronx", "Brooklyn", "Manhattan", "Queens", "Staten Island")
    val years = listOf(1980, 1990, 2000, 2010, 2020)
    val colors =
        listOf(
            Color.hsv(0f, 1f, 0.7f),
            Color.hsv(72f, 1f, 0.7f),
            Color.hsv(144f, 1f, 0.7f),
            Color.hsv(216f, 1f, 0.7f),
            Color.hsv(288f, 1f, 0.7f)
        ) // 1 color per borough

    // Population data is in order of borough, then year
    val population = listOf(
        listOf(1168972, 1203789, 1332650, 1385108, 1446788), // Bronx
        listOf(2230936, 2300664, 2465326, 2552911, 2648452), // Brooklyn
        listOf(1428285, 1487536, 1537195, 1585873, 1638281), // Manhattan
        listOf(1891325, 1951598, 2229379, 2250002, 2330295), // Queens
        listOf(352121, 378977, 443728, 468730, 487155), // Staten Island
    )

    XYGraph(
        xAxisModel = remember { CategoryAxisModel(years) },
        yAxisModel = rememberLinearAxisModel(0f..10f, minorTickCount = 0),
        yAxisTitle = "Population (Millions)"
    ) {
        StackedVerticalBarPlot {
            boroughs.forEachIndexed { index, borough ->
                series(solidBar(colors[index])) {
                    years.forEachIndexed { yearIndex, year ->
                        item(year, population[index][yearIndex].toFloat() / 1E6f)
                    }
                }
            }
        }
    }
}
