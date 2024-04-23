package io.github.koalaplot.example

import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.AnchorPoint
import io.github.koalaplot.core.xygraph.FloatLinearAxisModel
import io.github.koalaplot.core.xygraph.HorizontalLineAnnotation
import io.github.koalaplot.core.xygraph.Point
import io.github.koalaplot.core.xygraph.VerticalLineAnnotation
import io.github.koalaplot.core.xygraph.XYAnnotation
import io.github.koalaplot.core.xygraph.XYGraph

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    XYGraph(
        xAxisModel = FloatLinearAxisModel(0f..10f),
        yAxisModel = FloatLinearAxisModel(0f..20f),
    ) {
        HorizontalLineAnnotation(10.4f, LineStyle(SolidColor(Color.Blue)))
        VerticalLineAnnotation(3.2f, LineStyle(SolidColor(Color.Red)))
        XYAnnotation(Point(3.2f, 10.4f), AnchorPoint.BottomLeft) {
            Text("Text annotation")
        }
    }
}
