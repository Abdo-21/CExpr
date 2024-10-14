package com.abdo21.cexpr.operations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdo21.cexpr.utils.toDp



@Composable
fun SquareRoot(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    content: @Composable () -> Unit
) {
    var contentWidth by remember { mutableIntStateOf(0) }
    var contentHeight by remember { mutableIntStateOf(0) }

    val paddingLeft = remember(contentHeight) { contentHeight/6f }

    val paddingTop =  2.dp
    val paddingTopPx = with(LocalDensity.current) { paddingTop.toPx() }

    val strokeWidth = with(LocalDensity.current) { 1.dp.toPx() }


    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .matchParentSize()
        ) {
            val height = size.height
            val width = size.width

            val path = Path().apply {
                moveTo(0f, 0.7f*height)
                lineTo(paddingLeft/2, height)
                lineTo(paddingLeft, paddingTopPx/2)
                lineTo(width, paddingTopPx/2)
            }

            drawPath(
                color = color,
                path = path,
                style = Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                ),
            )
        }

        Row {
            Spacer(modifier = Modifier.width(paddingLeft.toDp()))
            Column {
                Spacer(modifier = Modifier.height(paddingTop))
                Box(
                    modifier = Modifier
                        .onSizeChanged {
                            contentWidth = it.width
                            contentHeight = it.height
                        }
                ) {
                    content()
                }
            }
        }
    }
}

@Composable
fun SquareRoot(
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    content: String
) = SquareRoot(
    modifier = modifier,
    color = color,
    content = {
        Text(text = content)
    }
)

@Preview(showBackground = true)
@Composable
private fun SquareRootPreview() {
    SquareRoot(
        content = "123456"
    )
}