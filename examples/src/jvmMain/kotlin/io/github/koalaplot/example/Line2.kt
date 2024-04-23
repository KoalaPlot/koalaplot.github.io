package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect.Companion.dashPathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.autoScaleXRange
import io.github.koalaplot.core.xygraph.autoScaleYRange
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel
import kotlin.math.exp
import kotlin.math.sqrt

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    val dataSquared = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), i * i.toFloat()))
        }
    }

    val dataExp = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), exp(sqrt(i.toFloat()))))
        }
    }

    XYGraph(
        rememberFloatLinearAxisModel(dataSquared.autoScaleXRange()),
        rememberFloatLinearAxisModel(dataSquared.autoScaleYRange())
    ) {
        LinePlot(
            dataSquared,
            lineStyle = LineStyle(SolidColor(Color.Blue))
        )
        LinePlot(
            dataExp,
            lineStyle = LineStyle(
                SolidColor(Color(0, 200, 0)),
                2.dp,
                dashPathEffect(floatArrayOf(20f, 10f))
            )
        )
    }
}
