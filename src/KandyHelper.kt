import org.jetbrains.kotlinx.dataframe.api.toDataFrame
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.tiles
import org.jetbrains.kotlinx.kandy.letsplot.scales.guide.LegendType
import org.jetbrains.kotlinx.kandy.letsplot.style.Style

data class Cell(val row: Int, val col: Int, val value: Char)

fun createPlotFor(input: List<List<Char>>, suffix: Int) {
    val df = input.flatMapIndexed { r, row ->
        row.mapIndexed { c, v -> Cell(r, c, v) }
    }.toDataFrame()

    df.plot {
        tiles {
            x("row")
            y("col")
            fillColor("value") {
                legend.type = LegendType.None
            }
        }
        layout {
            style(Style.Void)
        }
    }
    .save("Day04_${suffix}.png")
}