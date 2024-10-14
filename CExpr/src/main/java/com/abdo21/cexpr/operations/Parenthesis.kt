package com.abdo21.cexpr.operations

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Parenthesis(
    modifier: Modifier = Modifier,
    parenthesisColor: Color = Color.Black,
    parenthesisLineThickness: Dp = 1.dp,
    content : @Composable () -> Unit
) {
    val strokeWidth = with(LocalDensity.current) { parenthesisLineThickness.toPx() }
    Row(
        modifier = modifier
            .height(IntrinsicSize.Max),
        //verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.Center
    ) {
        // Left Parenthesis
        Canvas(
            modifier = Modifier
                .fillMaxHeight()
                .width(5.dp)
        ) {
            drawArc(
                color = parenthesisColor,
                startAngle = 90f, // Start from the bottom
                sweepAngle = 180f, // Sweep for a half-circle
                useCenter = false,
                size = size,
                style = Stroke(width = strokeWidth)
            )
        }

        content()

        // Right Parenthesis
        Canvas(
            modifier = Modifier
                .fillMaxHeight()
                .width(5.dp)
        ) {
            drawArc(
                color = parenthesisColor,
                startAngle = 270f, // Start from the top
                sweepAngle = 180f, // Sweep for a half-circle
                useCenter = false,
                size = size,
                style = Stroke(width = strokeWidth)
            )
        }
    }
}

@Composable
fun Parenthesis(
    content: String,
    modifier: Modifier = Modifier,
    parenthesisColor: Color = Color.Black,
    parenthesisLineThickness: Dp = 1.dp
) = Parenthesis(
    parenthesisColor = parenthesisColor,
    parenthesisLineThickness = parenthesisLineThickness,
    content = {
        Text(
            text = content,
            modifier = modifier
        )
    }
)

@Preview(showBackground = true)
@Composable
fun ParenthesisPreview1() {
    Parenthesis(
        content = {
            Text(
                text = "259+45"
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ParenthesisPreview2() {
    Parenthesis(
        content = "259+45"
    )
}
