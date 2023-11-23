package io.github.koalaplot.example

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.bar.BulletGraph
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi


@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication() {
    BulletGraph(modifier = Modifier.padding(16.dp).height(100.dp)) {
        label {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = KoalaPlotTheme.sizes.gap)
            ) {
                Text(
                    "Revenue 2005 YTD",
                    textAlign = TextAlign.End
                )
                Text(
                    "(US $ in thousands)",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        axis { labels { Text("${it.toInt()}") } }
        comparativeMeasure(260f)
        featuredMeasureBar(275f)
        ranges(0f, 200f, 250f, 300f)
    }
}
