package io.github.koalaplot.example

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.Symbol
import io.github.koalaplot.core.legend.ColumnLegend
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.generateHueColorPalette

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication() {
    val itemCount = 5
    val palette = generateHueColorPalette(itemCount)

    ColumnLegend(
        modifier = Modifier.padding(16.dp).border(1.dp, Color.Black).padding(16.dp),
        itemCount = itemCount,
        symbol = { Symbol(shape = RectangleShape, fillBrush = SolidColor(palette[it])) },
        label = { Text("Item $it") },
        value = { Text("${it * 10}%") }
    )
}
