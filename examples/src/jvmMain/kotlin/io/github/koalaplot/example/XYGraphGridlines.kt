package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.style.LineStyle
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
            horizontalMajorGridLineStyle = LineStyle(SolidColor(Color.Blue), strokeWidth = 3.dp),
            horizontalMinorGridLineStyle = LineStyle(
                SolidColor(Color.Blue),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(5f, 5f)),
            ),
            verticalMajorGridLineStyle = LineStyle(SolidColor(Color.DarkGray)),
            verticalMinorGridLineStyle = null,
        ) {
        }
    }
}
