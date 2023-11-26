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
import io.github.koalaplot.core.polar.PolarGraphDefaults
import io.github.koalaplot.core.polar.rememberAngularValueAxisModel
import io.github.koalaplot.core.polar.rememberFloatRadialAxisModel
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toDegrees

fun main() = singleWindowApplication {
    Box(modifier = Modifier.padding(16.dp)) {
        Polar3()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun Polar3() {
    PolarGraph(
        rememberFloatRadialAxisModel(List(6) { it.toFloat() }),
        rememberAngularValueAxisModel(),
        angularAxisLabelText = { "${it.toDegrees().value}\u00B0" },
        polarGraphProperties = PolarGraphDefaults.PolarGraphPropertyDefaults().copy(
            radialAxisGridLineStyle = LineStyle(SolidColor(Color.DarkGray)),
            angularAxisGridLineStyle = LineStyle(SolidColor(Color.Blue)),
            background = AreaStyle(SolidColor(Color.LightGray))
        )
    ) { }
}
