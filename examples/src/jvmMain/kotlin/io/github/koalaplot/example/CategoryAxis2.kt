package io.github.koalaplot.example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.style.KoalaPlotTheme
import io.github.koalaplot.core.util.VerticalRotation
import io.github.koalaplot.core.util.rotateVertically
import io.github.koalaplot.core.xygraph.CategoryAxisModel
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberFloatLinearAxisModel

fun main() = singleWindowApplication {
    val yAxisTitle = buildAnnotatedString {
        pushStyle(ParagraphStyle(textAlign = TextAlign.Center))
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.titleLarge.fontSize))
        append("Votes\n")
        pop()
        pushStyle(SpanStyle(color = Color.Gray, fontSize = MaterialTheme.typography.labelSmall.fontSize))
        append("(Millions)")
    }

    XYGraph(
        xAxisModel = CategoryAxisModel(IconCategories.entries),
        yAxisModel = rememberFloatLinearAxisModel(0f..4f, minorTickCount = 0),
        xAxisLabels = { it.icon() },
        xAxisTitle = {},
        yAxisLabels = { Text(it.toString()) },
        yAxisTitle = {
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
                Text(
                    yAxisTitle,
                    modifier = Modifier.rotateVertically(VerticalRotation.COUNTER_CLOCKWISE)
                        .padding(bottom = KoalaPlotTheme.sizes.gap)
                )
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
    }
}

enum class IconCategories(private val icon: ImageVector, private val color: Color) {
    MONEY(Icons.Default.Money, Color(0, 150, 0)),
    HOME(Icons.Default.Home, Color.Black),
    DELETE(Icons.Default.Delete, Color.Red),
    SETTINGS(Icons.Default.Settings, Color.Gray),
    CHECK(Icons.Default.CheckCircle, Color.Blue)
    ;

    @Composable
    fun icon() {
        Icon(icon, contentDescription = null, tint = color)
    }
}
