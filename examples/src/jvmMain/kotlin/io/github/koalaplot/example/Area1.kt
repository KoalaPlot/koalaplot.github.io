@file:Suppress("MagicNumber")

package io.github.koalaplot.example

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import io.github.koalaplot.core.line.AreaBaseline
import io.github.koalaplot.core.line.AreaPlot
import io.github.koalaplot.core.style.AreaStyle
import io.github.koalaplot.core.style.LineStyle
import io.github.koalaplot.core.util.ExperimentalKoalaPlotApi
import io.github.koalaplot.core.util.toString
import io.github.koalaplot.core.xygraph.Point
import io.github.koalaplot.core.xygraph.XYGraph
import io.github.koalaplot.core.xygraph.rememberLinearAxisModel
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.sqrt

@OptIn(ExperimentalKoalaPlotApi::class)
fun main() = singleWindowApplication {
    XYGraph(
        rememberLinearAxisModel(-5f..5f),
        rememberLinearAxisModel(0f..1f),
        xAxisTitle = "",
        yAxisTitle = "",
        xAxisLabels = { it.toString(1) },
        yAxisLabels = { it.toString(1) }
    ) {
        AreaPlot(
            data = distribution1,
            lineStyle = LineStyle(brush = SolidColor(Color(0xFF00498F)), strokeWidth = 2.dp),
            areaStyle = AreaStyle(
                brush = SolidColor(Color(0xFF00498F)),
                alpha = 0.5f,
            ),
            areaBaseline = AreaBaseline.ConstantLine(0f)
        )
        AreaPlot(
            data = distribution2,
            lineStyle = LineStyle(brush = SolidColor(Color(0xFF37A78F)), strokeWidth = 2.dp),
            areaStyle = AreaStyle(
                brush = SolidColor(Color(0xFF37A78F)),
                alpha = 0.5f,
            ),
            areaBaseline = AreaBaseline.ConstantLine(0f)
        )
    }
}

class NormalDistribution(val sigma: Float, val mu: Float) : AbstractList<Point<Float, Float>>() {
    companion object {
        val xAxisValues: List<Float> = buildList {
            val numSamples = 500
            val min = -5f
            val max = 5f

            for (i in 0..numSamples) {
                add(min + (max - min) * i / numSamples)
            }
        }
    }

    val max: Float by lazy {
        this.maxOf { it.y }
    }

    override val size: Int = xAxisValues.size

    override fun get(index: Int): Point<Float, Float> {
        return Point(xAxisValues[index], computeValue(xAxisValues[index], sigma, mu))
    }

    private fun computeValue(x: Float, sigma: Float, mu: Float): Float =
        (1.0 / (sigma * sqrt(2.0 * PI)) * exp(-0.5 * ((x - mu) / sigma).pow(2))).toFloat()
}

private const val Distribution1Mean = 1.2f
val distribution1 = NormalDistribution(1.0f, Distribution1Mean)

private const val Distribution2Mean = -0.4f
val distribution2 = NormalDistribution(0.5f, Distribution2Mean)
