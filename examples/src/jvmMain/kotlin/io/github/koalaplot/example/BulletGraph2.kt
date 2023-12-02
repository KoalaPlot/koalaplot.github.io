package io.github.koalaplot.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.BulletGraphs
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi


@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication() {
    @Composable
    fun TwoLineLabel(line1: String, line2: String) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(end = KoalaPlotTheme.sizes.gap)
        ) {
            Text(line1, textAlign = TextAlign.End)
            Text(line2, textAlign = TextAlign.End, style = MaterialTheme.typography.labelSmall)
        }
    }

    BulletGraphs(modifier = Modifier.padding(16.dp)) {
        bullet {
            label { TwoLineLabel("Revenue", "(US $ in thousands)") }
            axis { labels { Text("${it.toInt()}", style = MaterialTheme.typography.labelSmall) } }
            comparativeMeasure(250f)
            featuredMeasureBar(275f)
            ranges(0f, 150f, 225f, 300f)
        }
        bullet {
            label { TwoLineLabel("Profit", "%") }
            axis { labels { Text("${it.toInt()}%", style = MaterialTheme.typography.labelSmall) } }
            comparativeMeasure(26f)
            featuredMeasureBar(22.5f)
            ranges(0f, 20f, 25f, 30f)
        }
        bullet {
            label { TwoLineLabel("Avg Order Size", "U.S. $") }
            axis { labels { Text("${it.toInt()}", style = MaterialTheme.typography.labelSmall) } }
            comparativeMeasure(550f)
            featuredMeasureBar(325f)
            ranges(0f, 350f, 500f, 600f)
        }
    }
}
