package io.github.koalaplot.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.polar.PolarGraph
import io.github.koalaplot.core.polar.PolarPlotSeries
import io.github.koalaplot.core.polar.PolarPoint
import io.github.koalaplot.core.polar.rememberAngularValueAxisModel
import io.github.koalaplot.core.polar.rememberFloatRadialAxisModel
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.AngularValue
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toDegrees
import kotlin.math.PI
import kotlin.math.cos

fun main() = singleWindowApplication {
    Box(modifier = Modifier.padding(16.dp)) {
        Polar6()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun Polar6() {
    fun cardioid(theta: Double): Double = 2F * (1F + cos(theta))

    val data1: List<PolarPoint<Float, AngularValue>> = buildList {
        for (theta in 0..360) {
            add(PolarPoint(cardioid(theta * PI / 180F).toFloat(), theta.toFloat().toDegrees()))
        }
    }

    PolarGraph(
        rememberFloatRadialAxisModel(List(6) { it.toFloat() }),
        rememberAngularValueAxisModel(),
        angularAxisLabelText = { "${it.toDegrees().value}\u00B0" }
    ) {
        PolarPlotSeries(
            data1,
            lineStyle = LineStyle(SolidColor(Color.Blue), strokeWidth = 2.dp),
            areaStyle = AreaStyle(SolidColor(Color.Blue.copy(alpha = 0.2f)))
        )
    }
}
