package io.github.koalaplot.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.pie.PieChart
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import kotlin.random.Random

fun main() = singleWindowApplication {
    Box(modifier = Modifier.padding(16.dp)) {
        Pie1()
    }
}

@OptIn(ExperimentalKoalaPlotApi::class)
@Composable
fun Pie1() {
    val random = Random(10)

    val data: List<Float> = buildList {
        for (i in 1..10) {
            add(random.nextFloat() * 10f)
        }
    }

    PieChart(
        data,
        label = { i ->
            Text(data[i].toString())
        }
    )
}
