package io.github.koalaplot.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.polar.PolarGraph
import io.github.koalaplot.core.polar.rememberCategoryAngularAxisModel
import io.github.koalaplot.core.polar.rememberFloatRadialAxisModel
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi

fun main() = singleWindowApplication {
    Box(modifier = Modifier.padding(16.dp)) {
        Polar4()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun Polar4() {
    PolarGraph(
        rememberFloatRadialAxisModel(List(6) { it.toFloat() }),
        rememberCategoryAngularAxisModel(listOf("A", "B", "C", "D", "E")),
    ) { }
}
