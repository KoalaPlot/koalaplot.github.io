package io.github.koalaplot.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.LinePlot
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.xygraph.DefaultPoint
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.autoScaleXRange
import io.github.koalaplot.core.xygraph.autoScaleYRange
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel

fun main() = singleWindowApplication() {
    Column {
        Theming1()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
private fun ColumnScope.Theming1() {
    val data = buildList {
        for (i in 1..10) {
            add(DefaultPoint(i.toFloat(), i * i.toFloat()))
        }
    }

    XYGraph(
        rememberLinearAxisModel(data.autoScaleXRange()),
        rememberLinearAxisModel(data.autoScaleYRange()),
        modifier = Modifier.weight(0.5f)
    ) {
        LinePlot(
            data,
            lineStyle = LineStyle(SolidColor(Color.Blue))
        )
    }

    KoalaPlotTheme(axis = KoalaPlotTheme.axis.copy(color = Color.Black, minorGridlineStyle = null)) {
        XYGraph(
            rememberLinearAxisModel(data.autoScaleXRange()),
            rememberLinearAxisModel(data.autoScaleYRange()),
            modifier = Modifier.weight(0.5f)
        ) {
            LinePlot(
                data,
                lineStyle = LineStyle(SolidColor(Color.Blue))
            )
        }
    }
}
