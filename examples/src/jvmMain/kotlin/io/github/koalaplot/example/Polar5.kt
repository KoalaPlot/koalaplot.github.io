package io.github.koalaplot.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.Symbol
import io.github.koalaplot.core.polar.PolarGraph
import io.github.koalaplot.core.polar.PolarPlotSeries
import io.github.koalaplot.core.polar.PolarPoint
import io.github.koalaplot.core.polar.rememberAngularValueAxisModel
import io.github.koalaplot.core.polar.rememberFloatRadialAxisModel
import io.github.koalaplot.core.util.AngularValue
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toDegrees
import kotlin.random.Random

fun main() = singleWindowApplication {
    Box(modifier = Modifier.padding(16.dp)) {
        Polar5()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun Polar5() {
    val random = Random(10)

    val data1: List<PolarPoint<Float, AngularValue>> = buildList {
        for (i in 1..20) {
            add(PolarPoint(random.nextFloat() * 5f, (15.2f + random.nextFloat() * 15f).toDegrees()))
        }
    }
    val data2: List<PolarPoint<Float, AngularValue>> = buildList {
        for (i in 1..20) {
            add(PolarPoint(random.nextFloat() * 5f, (95f + random.nextFloat() * 35f).toDegrees()))
        }
    }

    PolarGraph(
        rememberFloatRadialAxisModel(List(6) { it.toFloat() }),
        rememberAngularValueAxisModel(),
        angularAxisLabelText = { "${it.toDegrees().value}\u00B0" }
    ) {
        PolarPlotSeries(data1, symbols = { Symbol(shape = CircleShape, fillBrush = SolidColor(Color.Blue)) })
        PolarPlotSeries(data2, symbols = { Symbol(shape = CircleShape, fillBrush = SolidColor(Color.Red)) })
    }
}
